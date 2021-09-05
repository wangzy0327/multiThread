package com.thread.concurrentAccess.volatileSync;

public class MyThread extends Thread{
    volatile public static int count;
    private static void addCount(){
        for(int i = 0;i < 100;i++) {
            synchronized (MyThread.class){
                count++;
            }
//            System.out.println(Thread.currentThread().getName()+"i = "+i+"count = "+count);
        }
        System.out.println("count = "+count);
    }
    @Override
    public void run(){
        addCount();
    }
}
