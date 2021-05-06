package com.example.demo.cglib;


/**
 * @author gino
 * 2021-05-06
 * 被代理的类，与jdk动态代理不同的是 cglib 动态代理的类 不用实现接口
 * 因为cglib动态代理是通过生成被代理类的子类去实现代理
 */
public class SayImpl {
    public void dogSay(){
        System.out.println("dog say wang wang wang ");
    }
    public void catSay(){
        System.out.println("cat say miao miao miao");
    }
    public static void persionSay(String name){
        System.out.println("persion say hello "+name);
    }
}
