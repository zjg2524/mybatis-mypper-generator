package com.jmeter.demo.controller;

import java.util.Date;

/**
 * 2019/3/5
 * Administrator
 * com.jmeter.demo.controller
 */
public class Test {
    public static void main(String[] args) {
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName()+"  --> "+t1.getId());
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println("================");
        System.out.println(t1.isInterrupted());

    }
}
