package com.example.demo.async;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.misc.Cleaner;

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
