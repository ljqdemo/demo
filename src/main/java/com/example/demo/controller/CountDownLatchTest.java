package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.web.servlet.server.Jsp;
import sun.awt.windows.ThemeReader;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * @author gino
 * 2021-03-04
 */
public class CountDownLatchTest {


/*    public static void main(String[] args) throws InterruptedException {
        final   CountDownLatch cdl=new CountDownLatch(10);

        for (int i = 0; i <10 ; i++) {
            Thread t=new Thread(()->{
                System.out.println("aaaaa");
                cdl.countDown();
                try {
                    cdl.await();
                    System.out.println("bbbb");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            t.start();
        }
        Thread.sleep(2000);
    }*/

    public static void main(String[] args) throws InterruptedException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "123465");
        Long a=jsonObject.getLong("a");
        System.out.println(a);
    }
}