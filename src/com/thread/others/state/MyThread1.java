package com.thread.others.state;

public class MyThread1 extends Thread{

    public MyThread1() {
        System.out.println("构造方法中的状态(这里实际查询的是main线程的状态)："+Thread.currentThread().getState());
    }

    @Override
    public void run(){
        System.out.println("run方法中的状态："+Thread.currentThread().getState());
    }
}
