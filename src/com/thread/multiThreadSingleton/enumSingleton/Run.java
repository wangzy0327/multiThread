package com.thread.multiThreadSingleton.enumSingleton;

public class Run {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(MyObject.connectionFactory.getConnection().hashCode());
        });
        Thread t2 = new Thread(()->{
            System.out.println(MyObject.connectionFactory.getConnection().hashCode());
        });
        Thread t3 = new Thread(()->{
            System.out.println(MyObject.connectionFactory.getConnection().hashCode());
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
