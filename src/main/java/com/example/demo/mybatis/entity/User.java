package com.example.demo.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gino
 * 2021-07-09
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private String  age;


}
