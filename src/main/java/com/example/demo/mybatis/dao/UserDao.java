package com.example.demo.mybatis.dao;

import com.example.demo.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gino
 * 2021-09-09
 */

@Repository
public interface UserDao {
    //不使用@Param
    public User getUserById(Integer id);
    //使用@Param
    public User getUserById(@Param("id") int id);

    public List<User> getUserByAge(@Param("age") int age);
}
