@Intercepts(
{ @Signature(type = StatementHandler.class, 
             method = "prepare", 
             args = { Connection.class }) 
})
public class BillShardDefault implements Interceptor {
    private final static Logger logger = LoggerFactory.getLogger(BillShardDefault.class);

    private String tableName;

    private List<String> tableNames = Lists.newArrayList();

    /**
     * 线程安全类，初始化常量，避免重复创建
     * **/
    private final static ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

    /**
     * 线程安全类，初始化常量，避免重复创建
     * **/
    private final static ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = 
        new DefaultObjectWrapperFactory();

    private final static String BOUNDSQL_NAME = "delegate.boundSql";

    private final static String BOUNDSQL_SQL_NAME = "delegate.boundSql.sql";

    private final static String SQL_PARAM_NAME = "delegate.parameterHandler.parameterObject";

    private final static ShardStrategy DEFAULTSTRATEGY = new DefaultShardStrategy();

    private final static String SHARDPARAM = "_shardParam";

    private final static String STRATEGY_SUFFIX = "Strategy";

    private Map<String , ShardStrategy> STRATEGY_CONTEXT = Maps.newHashMap();

    private Map<String , ShardStrategy> TABLE_ROUTER = Maps.newHashMap();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(
            statementHandler , 
            DEFAULT_OBJECT_FACTORY , 
            DEFAULT_OBJECT_WRAPPER_FACTORY);

        BoundSql boundSql = (BoundSql)metaObject.getValue(BOUNDSQL_NAME);
        String executeSql = boundSql.getSql();
        MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap)metaObject.getValue(SQL_PARAM_NAME);
        ShardParam shardParam = null;
        if (paramMap.containsKey(SHARDPARAM)) {
            shardParam = (ShardParam)paramMap.get(SHARDPARAM);
        }
        /** 临时注释掉这段代码 数据迁移完成需要去掉 **/
       //checkArgument(shardParam!=null , "_shardParam Param Can't Be Null");
        if(shardParam!=null){ /** 临时if条件判断数据迁移完成需要去掉 **/
            executeSql = decorateSql(executeSql , shardParam);
            metaObject.setValue(BOUNDSQL_SQL_NAME,executeSql);
        }
        return invocation.proceed();
    }

    private String decorateSql(String executeSql, ShardParam shardParam) {
        for(String tableName : tableNames){
            String newTaleName = TABLE_ROUTER.get(tableName).getTableName(tableName , shardParam);
            executeSql = executeSql.replaceAll(tableName,newTaleName);
        }
        return executeSql;
    }

    @Override
    public Object plugin(Object target) {

        if (target instanceof StatementHandler) {
            return Plugin.wrap(target , this);
        }else {
            return target;
        }
    }

    /**
     * Don't Modify Any Code
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        setShardStrategy(properties);
        setTableNames(properties);
    }

    private void setTableNames(Properties properties){
        tableName = properties.getProperty("tableNames");
        checkArgument(!Strings.isEmpty(tableName) , "参数[tableNames]必填!");
        List<String> tempTableRouterStrList = Lists.newArrayList(
                Splitter.on(",").trimResults().omitEmptyStrings().split(tableName)
        );
        for(String tempTableRouterStr : tempTableRouterStrList){
            List<String> single = Lists.newArrayList(
                    Splitter.on("|").omitEmptyStrings().trimResults().split(tempTableRouterStr)
            );
            checkArgument(!CollectionUtils.isEmpty(single) , "Config is not correct!");
            tableNames.add(single.get(0));
            if(single.size()==1){
                TABLE_ROUTER.put(single.get(0), DEFAULTSTRATEGY);
            }else {
                TABLE_ROUTER.put(single.get(0), STRATEGY_CONTEXT.get(single.get(1)));
            }
        }
    }

    private void setShardStrategy(Properties properties){
        try {
            for(Map.Entry entry : properties.entrySet()){
                String strategyClassNameKey = entry.getKey().toString();
                if(strategyClassNameKey.indexOf(STRATEGY_SUFFIX)!=-1){
                    String strategyClassName = entry.getValue().toString();
                    Class strategyClass = Class.forName(strategyClassName);

                    Object o = strategyClass.newInstance();
                    if(o instanceof ShardStrategy){
                        STRATEGY_CONTEXT.put(strategyClassNameKey , (ShardStrategy)o);
                    }else {
                        throw new IllegalStateException(
                            "strategyClass must implement interface ShardStrategy<P>"
                        );
                    }
                }
            }
        }catch (Exception e){
            logger.error("生成ShardStrategy策略失败", e);
            throw new RuntimeException(e);
        }

    }
}