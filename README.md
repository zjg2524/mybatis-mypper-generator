
------
# 昆明市公安局警情模型部署(20200528)

##  本次更新,更新两个需求
- 历史警情态势分析-总警情、治安警情、刑事警情增加历史态势分析
- 警情结果表保留接警表全字段


#### 1 历史警情态势分析-总警情、治安警情、刑事警情增加历史态势分析
    直接更新policingalarm的镜像即可
    镜像文件为policingalarm.0.2.tar.gz

本次更新，只需要将新的镜像push到harbor，然后修改现有的deployment即可。  
kubectl -n $NAMESPACE edit deploy policingalarm-four-color
然后修改其中的镜像为新镜像即可


#### 2 警情结果表保留接警表全字段

因为本次更新涉及到数据表的改动，因此新建一个表，以及对应的clickhouse sinker。  

为了区分新旧数据，保持旧格式的数据持续更新，
- clickhouse新建JQXQ_basesd_table_with_raw_columns和JQXQ_with_raw_columns
- kafka2model输出的topic 新增一个JQXQ2CK_with_raw_columns
- 新增一个clickhouse sinker来消费JQXQ2CK_with_raw_columns这个新topic的数据，然后保存到JQXQ_basesd_table_with_raw_columns这个新表中



#### 具体升级步骤如下
- cpu、memory资源配置可以参考现有的deploymet进行配置，提供的yaml文件中配置资源分配较少，实际可以增加一些
- namespace需要全部改成昆明环境的实际namespace


#### 2.1  clickhouse 新建table，见clickhouse/警情详情建表.sql, 表名自己进行配置  
    文件中的第一行  
    `CREATE TABLE JQXQ_based_table_with_raw_columns(`  
    第47行  
    `CREATE MATERIALIZED VIEW JQXQ_with_raw_columns(`  
    第140行  
    `BJFS as BJFS FROM JQXQ_based_table_with_raw_columns;`  
    这三处的表名,如果需要可以自行修改
    
##### 2.2 新建clickhouse sinker  
###### 2.2.1 先新建sinker-conf
clickhouse-sinker-conf.yaml 需要配置
- namespace，参考昆明已有的clickhouse-sinker-conf的配置
- kafka的地址
- clickhouse的地址


```
config.json: |+
    {
      "clickhouse": {
        "ch1": {
          "db": "default",
          "host": "pre1-clickhouse1",
          "dnsLoop" : false,
          "maxLifeTime": 300,
          "password": "",
          "port": 9000,
          "username": ""
        }
      },
      "kafka": {
        "kfk1": {
          "brokers": "pre1-kafka1:9092",
          "sasl": {
            "password": "",
            "username": ""
          }
        }
      },
      "common": {
        "bufferSize": 90000,
        "flushInterval": 5,
        "logLevel": "error"
      }
    }
```
上述配置需要注意的是，clickhouse中的host需要改成昆明环境的，kafka中的brokers可以改为昆明环境的，这两项可以参考昆明现有环境的配置。


```
kind: ConfigMap
metadata:
  name: clickhouse-sinker-conf-kafka2model-with-raw-columns
  namespace: zhuangwei
```
如上所示，文件最后的ConfigMap中的namespace需要改成昆明环境的   

最后运行kubectl create -f clickhouse/clickhouse-sinker-conf.yaml

另外，如果需要对kafka topic和clickhouse的表名进行修改，以可以在clickhouse-cinker-conf中进行修改，没有要求，使用默认的即可。



###### 2.2.2 然后新建clickhouse sinker
clickhouse_sinker.yaml 中需要修改
- namespace为昆明环境的，和clickhouse-sinker-conf.yaml中的配置一样

最后运行kubectl create -f clickhouse/clickhouse_sinker.yaml


##### 2.3 升级kafak2model
有了上面clickhouse中的表和clickhouse sinker，现在升级kafka2model   


解压新镜像，重新打tag，push到昆明的harbor上
然后修改现有的kafka2model的deploy部署，kubecetl -n $NAMESPACE edit deploy kafka2model

deploy修改主要有两处  
1. 升级镜像版本，改为最新上传的
2. 新增一个环境变量KAFKA_OUTPUT_TOPIC_CK_WITH_RAW_COLUMNS，变量值为JQXQ2CK_with_raw_columns



环境变量配置说明如下，其中KAFKA_OUTPUT_TOPIC_CK_WITH_RAW_COLUMNS新增加的，设置为：

variable | value | note  
----|----|----|
KAFKA\_INPUT\_SERVER |pre1-kafka1:9092,pre1-kafka2:9092,pre1-kafka3:9092| kafka服务地址,若kafka和kafka2model不在同一个namespace下,service name需要加上namespace名称|
KAFKA\_INPUT\_TOPIC | NEW\_QBZX\_JJDB |警情所在的topic|
KAFKA\_INPUT\_GROUP\_ID |k2m-0618|kafka2model消费警情topic的group id|
KAFKA\_OUTPUT\_TOPIC | JQXQ |模型处理完,再存到kafka中,用于后段查询|
KAFKA\_OUTPUT\_TOPIC\_CK | JQXQ2CK |模型处理完,再存到kakfa,此处只保留了数据中的```data```字段（只有处理后的字段）, 用于供clickhouse_sinker消费|
KAFKA\_OUTPUT\_TOPIC\_CK\_WITH\_RAW\_COLUMNS | JQXQ2CK_with_raw_columns |模型处理完,再存到kakfa,此处保留了原始数据的字段, 用于供clickhouse_sinker消费|
NAMESPACE | tensorflow | tf\_model\_server\_all服务所在的namespace名称 |
