package com.jmeter.demo.entity;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2018/12/20
 * Administrator
 * com.jmeter.demo.entity
 */
public class Test {
  public static void main(String[] args) {
     ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
     map.put("a1","100a");
     System.out.println(map.putIfAbsent("a2","200b"));
  }
}
