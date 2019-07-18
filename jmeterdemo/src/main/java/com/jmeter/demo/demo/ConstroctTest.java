package com.jmeter.demo.demo;

/**
 * 2018/12/22
 * Administrator
 * com.jmeter.demo.demo
 */
public class ConstroctTest {
    private static ConstroctTest test = new ConstroctTest();
    //静态变量sta1    未赋予初始值
    public static int sta1;
    //静态变量sta1    赋予初始值20
    public static int sta2 = 20;

    //构造方法中对于静态变量赋值
    private ConstroctTest() {
        System.out.println("sta1= "+sta1+"  sta2= "+sta2);
        sta1++;
        sta2++;
        System.out.println(sta1 +" --> "+sta2);
    }

    public static void main(String[] args) {
        System.out.println(ConstroctTest.sta1);
        System.out.println(ConstroctTest.sta2);
    }
}
