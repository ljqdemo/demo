package com.example.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gino
 * 2021-03-04
 */
public class Test {

    private  static  final  int  COUNT =100;


    public static void main(String[] args) throws InterruptedException {

    //线程池
    ExecutorService pool = Executors.newCachedThreadPool();
    //定义两个倒计时计数器
    //等待命令倒计时计数器
    final CountDownLatch countOrder = new CountDownLatch(1);
    //等待反馈倒计时计数器
    final CountDownLatch countAnswer = new CountDownLatch(3);

    //3个子线程
		for(int i = 0; i < 3; i++){
        Runnable target = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() +
                            "-等待命令");
                    //等待countOrder为0时停止等待，向下执行
                    countOrder.await();

                    System.out.println(Thread.currentThread().getName() +
                            "-得到命令，开始执行");
                    Thread.sleep((long)(Math.random()*10000));
                    System.out.println(Thread.currentThread().getName() +
                            "-命令执行完成，回应结果");
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
                "-即将发布命令");
        //将countOrder减一
        countOrder.countDown();
        System.out.println(Thread.currentThread().getName() +
                    "-已发布命令，等待回应");
        //等待回应
        countAnswer.await();
        System.out.println(Thread.currentThread().getName() +
                "-已收到所有回应结果");
    }catch(InterruptedException e) {
        e.printStackTrace();
    }

		pool.shutdown();
}

}
