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
public class Thread04 {
    //脏读

    private String username = "aaron";
    private String password = "123";

    public synchronized void setValue(String username, String password) {

        this.username = username;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.password = password;

        System.out.println("set value: " + username + " " + password);

    }

    public void getValue() {
        System.out.println("get value: " + username + " " + password);
    }


    public static void main(String[] args) {
        final Thread04 example = new Thread04();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                example.setValue("hello", "world");
            }
        });

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        example.getValue();
    }




}
