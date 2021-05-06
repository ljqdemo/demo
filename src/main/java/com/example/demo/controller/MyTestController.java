package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gino
 * 2021-01-06
 */
@RestController
public class MyTestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @GetMapping("/hello")
    public String  hello( ){
        return  "Hello Sentinel ";
    }


    @GetMapping
    public String  HelloSentinel( String version ){
        return  "Hello Sentinel "+version;
    }


  public String  handleFlowQpsException(String version){
      return  " Method handleFlowQpsException  "+version;
  }

    public String  Fallback(String version){
        return  " Method  Fallback  "+version;
    }


}
