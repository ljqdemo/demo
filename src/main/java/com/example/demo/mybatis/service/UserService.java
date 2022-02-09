package com.example.demo.mybatis.service;

import com.example.demo.mybatis.dao.UserDao;
import com.example.demo.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UserService {

    @Autowired
    private UserDao userDao;

    public User queryUser(int id){
        return userDao.getUserById(id);
    }
    public List<User> queryUser2(int age){
        return userDao.getUserByAge(age);
    }
}
