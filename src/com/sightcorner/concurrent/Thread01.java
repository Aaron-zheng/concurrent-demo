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
public class Thread01 extends Thread{
    //线程安全

    private int count = 5;


    /**
     * synchronized
     */
    @Override
    public synchronized void run() {
        count--;
        System.out.println(this.currentThread().getName() + " count: " + count);
    }



    public static void main(String[] args) {

        //线程不安全

        Thread01 thread01 = new Thread01();
        Thread t1 = new Thread(thread01, "t1");
        Thread t2 = new Thread(thread01, "t2");
        Thread t3 = new Thread(thread01, "t3");
        Thread t4 = new Thread(thread01, "t4");
        Thread t5 = new Thread(thread01, "t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
