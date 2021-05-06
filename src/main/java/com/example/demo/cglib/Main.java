package com.example.demo.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author gino
 * 2021-05-06
 */
public class Main {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //继承被代理类
        enhancer.setSuperclass(SayImpl.class);
        //设置回调
        enhancer.setCallback(new SayInterceptor());
        //设置代理类对象
        SayImpl say = (SayImpl) enhancer.create();
        //在调用代理类中方法时会被我们实现的方法拦截器进行拦截
        say.dogSay();

        say.catSay();
        //调用静态方法 不会走拦截
        SayImpl.persionSay("gino");
        say.persionSay(" ooo");
    }
}
