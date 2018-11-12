package com.env.dubboapi.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
    
    private static final long serialVersionUID = 288405442887035476L;
    private int sid;
    private String sname;
    private String pwd;

}
