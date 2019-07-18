package com.jmeter.demo.mongo;

//import com.mongodb.Block;
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import static com.mongodb.client.model.Filters.*;
//import org.bson.Document;
//
//import javax.imageio.stream.IIOByteBuffer;
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;

/**
 * 2019/3/20
 * Administrator
 * com.jmeter.demo.mongo
 */
public class MongoDemo {

//    private static MongoClient mongoClient = null;
//    private static MongoDatabase database = null;
//    private static MongoCollection<Document> info = null;
//    public static void main(String[] args) {
//        init();
//        insertDemo();
//    }
//
//    public static  void insertDemo(){
//        Document doc1 = new Document();
//        doc1.append("username", "cang");
//        doc1.append("country", "USA");
//        doc1.append("age", 20);
//        doc1.append("lenght", 1.77f);
////        doc1.append("salary", new BigDecimal("6565.22"));//存金额，使用bigdecimal这个数据类型
//
//        //添加“address”子文档
//        Map<String, String> address1 = new HashMap<String, String>();
//        address1.put("aCode", "0000");
//        address1.put("add", "xxx000");
//        doc1.append("address", address1);
//
//        //添加“favorites”子文档，其中两个属性是数组
//        Map<String, Object> favorites1 = new HashMap<String, Object>();
//        favorites1.put("movies", Arrays.asList("aa","bb"));
//        favorites1.put("cites", Arrays.asList("东莞","东京"));
//        doc1.append("favorites", favorites1);
//
//        Document doc2  = new Document();
//        doc2.append("username", "Chen");
//        doc2.append("country", "China");
//        doc2.append("age", 30);
//        doc2.append("lenght", 1.77f);
////        doc2.append("salary", new BigDecimal("8888.22"));
//        Map<String, String> address2 = new HashMap<>();
//        address2.put("aCode", "411000");
//        address2.put("add", "我的地址2");
//        doc2.append("address", address2);
//        Map<String, Object> favorites2 = new HashMap<>();
//        favorites2.put("movies", Arrays.asList("东游记","一路向东"));
//        favorites2.put("cites", Arrays.asList("珠海","东京"));
//        doc2.append("favorites", favorites2);
//
//        //使用insertMany插入多条数据
//        info.insertMany(Arrays.asList(doc1,doc2));
//
//    }
//
//    public static void findData(){
////        Block<Document> documentBlock = new Block<>() {
////            @Override
////            public void apply(Object o) {
////                System.out.println(o);
////            }
////        };
//
////       all()
//    }
//    public static void init() {
//        mongoClient = new MongoClient("192.168.144.130", 27017);
//        database = mongoClient.getDatabase("test");
//        info = database.getCollection("info");
//    }
}
