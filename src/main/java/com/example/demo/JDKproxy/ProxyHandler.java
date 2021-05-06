package com.example.demo.JDKproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author gino
 * 2021-04-30
 */
public class ProxyHandler implements InvocationHandler {

    private  Object taget;

    /**
     * 通过构造方法将被代理代理对象设置进来
     * @param taget
     */
    public ProxyHandler(Object taget) {
        this.taget = taget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method invoke before  doing "+method.getName());
        Object returnValue=method.invoke(taget,args);
        System.out.println("method invoke after  doing "+method.getName());
        return returnValue;
    }
}
