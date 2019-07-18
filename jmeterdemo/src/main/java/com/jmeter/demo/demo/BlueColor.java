package com.jmeter.demo.demo;

import javax.swing.*;

/**
 * 2018/12/8
 * Administrator
 * com.jmeter.demo.demo
 */
public class BlueColor implements IColor {
    private String name = "bule";
    private String desc = "bule";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BlueColor{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

}
