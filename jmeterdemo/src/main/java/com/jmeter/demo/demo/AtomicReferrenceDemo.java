package com.jmeter.demo.demo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 2018/12/16
 * Administrator
 * com.jmeter.demo.demo
 */
public class AtomicReferrenceDemo {
    private static AtomicReference<User> referrence = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User();
        user.setSname("huahua");
        user.setAge(18);

        User userUpdate = new User();
        userUpdate.setSname("xiaoming");
        userUpdate.setAge(30);

        referrence.set(user);
        boolean flag=false;
        while (!flag){

            flag = referrence.compareAndSet(user, userUpdate);
            System.out.println("flag --> "+flag);
        }
        System.out.println(referrence.get());
        System.out.println("src --> "+user);
    }
}
