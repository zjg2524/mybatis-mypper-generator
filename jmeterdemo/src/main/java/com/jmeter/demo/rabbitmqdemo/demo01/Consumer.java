package com.jmeter.demo.rabbitmqdemo.demo01;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/**
 * 2019/3/6
 * Administrator
 * com.jmeter.demo.rabbitmqdemo.demo01
 */
public class Consumer {

    public static void main(String[] argv) throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {
        /* 建立连接 */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");// MQ的IP
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(Product.EXCHANGENAME, BuiltinExchangeType.DIRECT);

        /* 声明要连接的队列 */
        channel.queueDeclare("errorQueue", false, false, false, null);
        channel.queueBind("errorQueue",Product.EXCHANGENAME,"error");
        System.out.println("等待消息产生：");

        /* 创建消费者对象，用于读取消息 */
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("msg --> "+msg+"  Exchange --> "+envelope.getExchange()+"  routingKey --> "+envelope.getRoutingKey());
            }
        };

        channel.basicConsume("errorQueue", true, defaultConsumer);




    }
}
