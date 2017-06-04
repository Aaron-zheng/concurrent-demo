package com.sightcorner.concurrent;

/**
 * Created by Aaron Zheng<br>
 * Created at 29/5/2017<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 29/5/2017
 */
public class Thread03 {
    //同步和异步

    public synchronized void method1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final Thread03 example = new Thread03();


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.method1();
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.method2();
            }
        }, "thread2");


        thread1.start();
        thread2.start();
    }




}
