package com.jmeter.demo.demo;

/**
 * 2018/12/16
 * Administrator
 * com.jmeter.demo.demo
 */
public class User {

    private String sname;
    private int age;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }
}
