package com.example.demo.JDKproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author gino
 * 2021-04-29
 */
public class main {
    public static void main(String[] args) {


       //jdk动态代理类的必须实现一个或者多个接口

        // 1. 创建被代理的对象，UserService接口的实现类
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        //创建代理对象,并告知代理对象代理的是谁
        InvocationHandler handler=new ProxyHandler(userServiceImpl);
        //获取被代理对象的类加载器和类实现的接口
        ClassLoader loader = userServiceImpl.getClass().getClassLoader();
        Class[] interfaces = userServiceImpl.getClass().getInterfaces();
        //通过Proxy 对象获取代理对象
        UserService porxy = (UserService) Proxy.newProxyInstance(loader, interfaces, handler);
        porxy.delete(99);
        Log porxy2 = (Log) Proxy.newProxyInstance(loader, interfaces, handler);
        porxy2.savelog();
    }
}
