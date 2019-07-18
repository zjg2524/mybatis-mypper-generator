package com.jmeter.demo.rabbitmqdemo.demo01;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/**
 * 2019/3/6
 * Administrator
 * com.jmeter.demo.rabbitmqdemo.demo01
 */
public class Product {
    public static String EXCHANGENAME="direct_logs";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        Connection connection = connectionFactory.newConnection();
        System.out.println(connection);
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGENAME, BuiltinExchangeType.DIRECT);
//        channel.queueDeclare()
        String [] keys = {"error","info","warn"};
        for (int i = 0; i < 3; i++) {
            String key = null;
            try {
                key = keys[keys.length%(i+1)];
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            ArrayList<Object> objects = new ArrayList<>();
            for (Object object : objects) {
                
            }
            String msg = "rabbitmq test "+(i+1);
            System.out.println("publish message --> "+msg+"  routingkey --> "+key);
            channel.basicPublish(EXCHANGENAME,key,null,msg.getBytes());
        }

        channel.close();
        connection.close();
    }



}
