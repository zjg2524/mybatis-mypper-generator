package com.example1207.provider8001.dao;

import com.example1207.provider8001.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 2018/12/7
 * Administrator
 * com.example1207.provider8001.dao
 */
public interface UserJpa extends JpaRepository<User,Integer> {
}
