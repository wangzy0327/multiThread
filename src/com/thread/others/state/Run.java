package com.thread.others.state;

public class Run {
    //NEW
    //RUNNABLE
    //TERMINATED
    //BLOCKED
    //WAITING
    //TIMED_WAITING

    public static void main(String[] args) {
        try {
            MyThread t = new MyThread();
            t.start();
            Thread.sleep(1000);
            System.out.println("main方法中的t状态："+t.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lock.lock.wait();
     *
     * main方法中的t状态：WAITING
     *
     */


    /**
     *
     * Lock.lock.wait(3000);
     *
     * main方法中的t状态：TIMED_WAITING
     *
     */
}
