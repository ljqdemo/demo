package com.example.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author gino
 * 2021-04-29
 */
public class LogHandler implements InvocationHandler {
    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置处理
        System.out.println("before deal");

        // 调用 target 的 method 方法
        Object result = method.invoke(target, args);
        //后置处理
        System.out.println("after deal");

        return result;
    }

    public static void main(String[] args) {
        AtomicLong count=new AtomicLong(0);
      Long result=  count.incrementAndGet();
        System.out.println(result);

        Vector v=new Vector(1);
        v.add("10");
        v.addElement("20");
        for (Object o : v) {
            System.out.println(o);
        }

    }

}
