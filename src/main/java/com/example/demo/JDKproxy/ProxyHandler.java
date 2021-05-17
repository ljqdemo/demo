package com.example.demo.JDKproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author gino
 * 2021-04-30
 */
public class ProxyHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private  Object taget;

    /**
     * 通过构造方法将被代理代理对象设置进来
     * @param taget
     */
    public ProxyHandler(Object taget) {
        this.taget = taget;
    }

    /***
     *
     * @param proxy  代理对象
     * @param method 方法对象
     * @param args  方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method invoke before  doing "+method.getName());
        Object returnValue=method.invoke(taget,args);
        System.out.println("method invoke after  doing "+method.getName());
        return returnValue;
    }
}
