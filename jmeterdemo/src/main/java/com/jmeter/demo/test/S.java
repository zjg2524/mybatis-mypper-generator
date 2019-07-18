package com.jmeter.demo.test;

/**
 * 2019/3/1
 * Administrator
 * com.jmeter.demo.test
 */
public class S extends F {

    {
        System.out.println("S代码块。。。。。。。。。");
    }

    static {
        System.out.println("S static代码块。。。。。。。。。");
    }

    public S() {
        System.out.println("S构造方法。。。。。。。。。。。。。。");
    }
}
