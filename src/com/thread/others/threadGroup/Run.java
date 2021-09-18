package com.thread.others.threadGroup;

public class Run {
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            try {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("ThreadName = "+Thread.currentThread().getName());
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread b = new Thread(()->{
            try {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("ThreadName = "+Thread.currentThread().getName());
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ThreadGroup group = new ThreadGroup("张昱涵的线程组");
        Thread aThread = new Thread(group,a);
        Thread bThread = new Thread(group,b);
        aThread.start();
        bThread.start();
        System.out.println("活动的线程数为："+group.activeCount());
        System.out.println("线程组的名称为："+group.getName());
    }
}
