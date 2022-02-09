package com.example.demo.concurrent;

import ch.qos.logback.core.util.COWArrayList;

import java.util.Random;

/**
 * @author gino
 * 2021-07-01
 */
public class NoVisbility {
    private static boolean read;
    private static int number;



    private static class ReadThread extends Thread{
        private  ThreadLocal<String> threadLocal =new  ThreadLocal();
        @Override
        public void run() {
            read=false;
            while (!read){
                //线程让步
                Thread.yield();
                threadLocal.set(new Random().nextInt(10)+"11");
                System.out.println(number);
                System.out.println( "getValue"+threadLocal.get());;
                read=true;
            }
        }


    }
    public static void main(String[] args) throws InterruptedException {
        ReadThread thread=new ReadThread();
        thread.start();
        ReadThread thread2=new ReadThread();
        thread2.start();
        number=10;
        read=false;
        Thread.sleep(1000);
    }
}
