package com.example.demo.async;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author gino
 * 2021-05-17
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AsyncTest {
    @Autowired
    private AsyncTask task;

    @Test
    public void testDealNoReturnTask() throws InterruptedException {
        task.methodB();
        try {
            System.out.println("Invoke task.methodB() end");
           // Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
