package com.thread.multiThreadSingleton.hungryMode;

/**
 * 饿汉 单例模式
 *
 */
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
     * 270921682
     * 270921682
     * 270921682
     *
     */
}
