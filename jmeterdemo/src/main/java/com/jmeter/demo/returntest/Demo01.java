package com.jmeter.demo.returntest;

import com.jmeter.demo.demo.User;

/**
 * 2019/2/22
 * Administrator
 * com.jmeter.demo.returntest
 */
public class Demo01 {

    public static void main(String[] args) {
        User user = test02();
        System.out.println(user);
    }

    public static int test01() {
        int i=0;
        try{
            i=100;
            System.out.println("try中的i --> "+i);
            return i;
        }finally {
            i=300;
            System.out.println("catch中的I --> "+i);
//            return 1;
        }


    }

    public static User test02() {
        User user = new User();
        try{
            user.setSname("huahua");
            user.setAge(18);
            System.out.println("try中的i --> "+user);
            return user;
        }finally {
            user.setSname("xiaoming");
            user.setAge(22);
            System.out.println("catch中的I --> "+user);
//            return 1;
        }


    }
}
