package com.jmeter.demo.rabbitmqdemo.demo01;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 2019/3/10
 * Administrator
 * com.jmeter.demo.rabbitmqdemo.demo01
 */
@ConditionalOnMissingBean
public class Test {


    public static void main(String[] args) {


    }


    public static int add(int i,int j){


        return 5;
    }
}
