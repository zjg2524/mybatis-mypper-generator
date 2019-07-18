package com.jmeter.demo.test;

/**
 * 2018/12/11
 * Administrator
 * com.jmeter.demo.test
 */
public class BadFly implements Fly {
    @Override
    public void flyAction() {
        System.out.println("bad fly");
    }
}
