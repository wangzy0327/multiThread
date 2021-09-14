package com.thread.multiThreadSingleton.staticCodeBlock;

public class Run {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(MyObject.getInstance().hashCode());
        });
        Thread t2 = new Thread(()->{
            System.out.println(MyObject.getInstance().hashCode());
        });
        Thread t3 = new Thread(()->{
            System.out.println(MyObject.getInstance().hashCode());
        });
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 1037172763
     * 1037172763
     * 1037172763
     *
     */
}
