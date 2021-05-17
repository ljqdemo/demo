package com.example.demo.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author gino
 * 2021-05-06
 */
public class SayInterceptor implements MethodInterceptor {

    /**
     * 代理方法
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //方法调用前处理的业务
        System.out.println("Before "+method.getName()+"doing");
        //调用方法
        Object result=methodProxy.invokeSuper(o,objects);
        //方法调用结束后的处理业务
        System.out.println("After "+ method.getName()+" doing");
        return result;
    }
}
