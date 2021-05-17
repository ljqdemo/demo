package com.example.demo.spring.annotation.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author gino
 * 2021-05-17
 * 设置异步方法
 */
@Component
public class AsyncTask {

        @Async
        public void methodB() throws InterruptedException {
            System.out.println("Invoke MethodB");
            Thread.sleep(3000);
            System.out.println("Invoke MethodB End");
            return ;
        }

}
