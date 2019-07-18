package com.jmeter.demo.build;

/**
 * 2019/1/31
 * Administrator
 * com.jmeter.demo.build
 */
public class User {

    public String name;
    public String hobby;
    public String desc;
    public int age;
    public String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                ", desc='" + desc + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
