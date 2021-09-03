package com.thread.coreAPI.stopThread.sleep;

/**
 * 在沉睡中 被 停止
 *
 * 如果在sleep状态下停止某一线程，会进入catch语句，并且清除停止状态值，使之变成false。
 *
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread5 thread = new MyThread5();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
    /**
     * run begin!
     * 在沉睡中被停止！进入catch!false
     * java.lang.InterruptedException: sleep interrupted
     */
}
