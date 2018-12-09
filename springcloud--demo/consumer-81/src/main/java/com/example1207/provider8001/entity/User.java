package com.example1207.provider8001.entity;

import java.io.Serializable;

/**
 * 2018/12/7
 * Administrator
 * com.example1207.provider8001.entity
 */
public class User implements Serializable {
    private Integer sid;
    private String sname;
    private String pwd;
    private Integer sage;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
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
