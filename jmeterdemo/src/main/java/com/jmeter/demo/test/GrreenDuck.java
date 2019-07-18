package com.jmeter.demo.test;

/**
 * 2018/12/11
 * Administrator
 * com.jmeter.demo.test
 */
public class GrreenDuck extends Duck {
    @Override
    public void display() {
        System.out.println("green duck......");
    }

    public GrreenDuck() {

        fly = new BestFly();
        talk = new HighTalk();
    }
}
