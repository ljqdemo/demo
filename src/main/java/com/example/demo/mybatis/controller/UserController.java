package com.example.demo.mybatis.controller;

import com.example.demo.mybatis.entity.User;
import com.example.demo.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(@RequestParam("id") int id){
        return userService.queryUser(id);
    }

    @GetMapping("/getUser2")
    public List<User> getUser2(@RequestParam("age") int age){
        return userService.queryUser2(age);
    }
}
