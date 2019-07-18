package com.jmeter.demo.entity;

import javax.persistence.Table;
import java.util.Date;

/**
 * 2018/11/26
 * Administrator
 * com.jmeter.demo.entity
 */

@Table(name = "orders")

public class Orders {
    private Integer id;
    private String name;
    private Date date;
    private String desc;
    private int uid;
    private Users users = new Users();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", desc='" + desc + '\'' +
                ", uid=" + uid +
                ", users=" + users +
                '}';
    }
}
