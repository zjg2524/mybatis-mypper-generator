package com.jmeter.demo.build;

/**
 * 2019/1/31
 * Administrator
 * com.jmeter.demo.build
 */
public class Test {

    public static void main(String[] args) {
        User user = Build.getBuild().name("huahua")/*.hobby("play")*/.desc("high").age(18).sex("mate").build();
        System.out.println(user);
    }
}
