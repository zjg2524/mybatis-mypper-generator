package com.jmeter.demo.config;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * 2018/12/6
 * Administrator
 * com.jmeter.demo.config
 */
public class MyPasswordDecode implements PasswordEncoder {
    private static final String SALT = "123456";
    private static final BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
    @Override
    public String encode(CharSequence charSequence) {

        return encode.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode.matches(charSequence,s);
    }

    public static void main(String[] args) {
        String encode1 = MyPasswordDecode.encode.encode("123abc");
        System.out.println(encode1);
        String encode2 = MyPasswordDecode.encode.encode("123abc");
        System.out.println(encode2);
        String encode3 = MyPasswordDecode.encode.encode("123abc");
        System.out.println(encode3);

    }
}
