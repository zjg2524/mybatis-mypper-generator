package com.jmeter.demo.test;

/**
 * 2018/12/11
 * Administrator
 * com.jmeter.demo.test
 */
 abstract class Duck {

    public Fly fly;
    public talk talk;
    abstract void display();

    public void talkAction(){
        talk.talkAction();
    }

    public void flyAction(){
        fly.flyAction();
    }

}
