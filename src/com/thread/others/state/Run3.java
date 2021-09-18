package com.thread.others.state;

public class Run3 {
    //NEW
    //RUNNABLE
    //TERMINATED
    //BLOCKED
    //WAITING
    //TIMED_WAITING
    public static void main(String[] args) {
        try {
            MyThread1 t1 = new MyThread1();
            System.out.println("main方法中线程t1的状态1："+ t1.getState());
            t1.join(1000);
            t1.start();
            t1.join(1000);
            System.out.println("main方法中的状态2："+t1.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 构造方法中的状态(这里实际查询的是main线程的状态)：RUNNABLE
     * main方法中线程t1的状态1：NEW
     * run方法中的状态：RUNNABLE
     * main方法中的状态2：TERMINATED
     *
     */
}
