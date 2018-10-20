package com.jmeter.demo.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 2018/10/9
 * Administrator
 * com.jmeter.demo.entity
 */
@Table(name = "users")
@Component
public class User {

    @Id
    private int sid;

    private String  sname;
    private String  pwd;
    private int sage;

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getPwd() {
        return pwd;
    }

    public int getSage() {
        return sage;
    }

    @Override
    public String toString() {
        return "User{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sage=" + sage +
                '}';
    }
}
