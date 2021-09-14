package com.thread.multiThreadSingleton.lazyMode.safe.DCL;

/**
 * DCL  double check lock
 *
 * 双重检验锁 机制
 *
 *  单例模式 - 线程安全
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
     * 1902102109
     * 1902102109
     * 1902102109
     *
     */
}
