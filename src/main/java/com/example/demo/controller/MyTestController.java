package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) {

        Person grandfather=new Person("0","1","grandfather");
        Person father=new Person("1","2","father");
        Person uncle=new Person("1","3","uncle");
        Person uncle2=new Person("1","4","uncle2");
        Person brother=new Person("2","5","brother");
        Person brother2=new Person("3","6","brother2");
        Person me=new Person("3","7","me");

        List<Person> family=new ArrayList<>();
        family.add(grandfather);
        family.add(father);
        family.add(uncle);
        family.add(uncle2);
        family.add(brother);
        family.add(brother2);
        family.add(me);

        Person person=listToTree(family);
    }
    public static  Person listToTree( List<Person> family){
        Person gradfather=null;
        //第一步找出最顶级的祖父
        for (Person person:family){
            if(person.parentCode.equals("0")){
                //找出祖父的所有子孙
                findMyChilder(person,family);
                gradfather=person;
            }
        }
        String str =gradfather.toString();
        System.out.println("array :"+str);
        return gradfather;
    }

    //查询当前节点的子孙节点
    public static void findMyChilder(Person my,List<Person> family){
        List<Person> childrens=new ArrayList<>();
        my.childrens=childrens;
        //查找当前节点的直属孩子
        for (Person person:family){
            if(person.parentCode.equals(my.Code)){
                my.childrens.add(person);
            }
        }
        //查找孩子的孩子
        if(my.childrens.size()>0){
            for (Person children:my.childrens){
                findMyChilder(children,family);
            }
        }
    }
    static class Person{
        public  String parentCode;
        public  String  Code;
        public  String name;
        public  List<Person> childrens;

        public Person(String parentCode, String code, String name) {
            this.parentCode = parentCode;
            this.Code = code;
            this.name = name;
        }

        public Person() {
        }

        @Override
        public String toString() {
            return "Person{" +
                    "parentCode='" + parentCode + '\'' +
                    ", Code='" + Code + '\'' +
                    ", name='" + name + '\'' +
                    ", childrens=" + childrens +
                    '}';
        }
    }

}
