package com.jmeter.demo.mongo;

import org.springframework.beans.factory.annotation.Value;

/**
 * 2019/3/20
 * Administrator
 * com.jmeter.demo.mongo
 */
public class Test {
    @Value("${host.ip}")
    private static String ip ;


    public static void main(String[] args) {
        System.out.println(ip);
        }
}
