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
public class Thread02 {
    //1个对象有一把锁
    //多个线程获取多个锁
    //

    private int num = 0;


    //如果需要获得一个类锁（类级别的锁），就需要在方法添加static
    //否则该方法的synchronized只是对象锁
    public synchronized void printNum(String tag) {
        try {
            if(tag.equals("a")) {
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }

            System.out.println("tag " + tag + " num: " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        final Thread02 t1 = new Thread02();
        final Thread02 t2 = new Thread02();


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t1.printNum("a");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t2.printNum("b");
            }
        });

        thread1.start();
        thread2.start();
    }
}
