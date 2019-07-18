package com.jmeter.demo.build;

/**
 * 2019/1/31
 * Administrator
 * com.jmeter.demo.build
 */
public class Build {
    private String name;
    private String hobby;
    private String desc;
    private int age;
    private String sex;

    public static Build getBuild(){
        return new Build();
    }

    public Build name(String name){
        this.name = name;
        return this;
    }

    public Build hobby(String hobby){
        this.hobby = hobby;
        return this;
    }

    public Build desc(String desc){
        this.desc = desc;
        return this;
    }

    public Build sex(String sex){
        this.sex = sex;
        return this;
    }

    public Build age(int age){
        this.age = age;
        return this;
    }
    public User build(){
        User user = new User();
        user.name=name;
        user.hobby=hobby;
        user.desc=desc;
        user.sex=sex;
        user.age=age;
        return user;
    }
}
