package com.example.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gino
 * 2021-06-28
 */
public class ConcurrentUtils {

    /**
     * 当前线程数
     */
    private  static int  COUNT =100;

    public static void test(){
        ExecutorService pool = Executors.newCachedThreadPool();
        //定义两个倒计时计数器
        //等待命令倒计时计数器
        final CountDownLatch countOrder = new CountDownLatch(1);
        //等待反馈倒计时计数器
        final CountDownLatch countAnswer = new CountDownLatch(COUNT);

        for(int i = 0; i < COUNT; i++){
            Runnable target = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() +
                                "_waiting");

                        //等待countOrder为0时停止等待，向下执行
                        countOrder.await();

                        System.out.println(Thread.currentThread().getName() +
                                "-Get the order, start execution");
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println(Thread.currentThread().getName() +
                                "-The command is executed and the result is responded");
                        //将countAnswer减一
                        countAnswer.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            pool.execute(target);
        }
        //主线程
        try{
            Thread.sleep((long)(Math.random()*10000));
            System.out.println(Thread.currentThread().getName() +
                    "-orderIsAboutToBeIssued");
            //将countOrder减一
            countOrder.countDown();
            System.out.println(Thread.currentThread().getName() +
                    "-commandIssuedWaitingForResponse");
            //等待回应
            countAnswer.await();
            System.out.println(Thread.currentThread().getName() +
                    "-allResponseResultsHaveBeenReceived");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }

}
