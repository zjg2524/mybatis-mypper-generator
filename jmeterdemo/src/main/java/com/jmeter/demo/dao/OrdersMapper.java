package com.jmeter.demo.dao;

import com.jmeter.demo.entity.Orders;

import java.util.List;

/**
 * 2018/11/26
 * Administrator
 * com.jmeter.demo.dao
 */
public interface OrdersMapper {

    public List<Orders> selectUserAndOrder2(int id);
}
