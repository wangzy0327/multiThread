package com.thread.multiThreadSingleton.lazyMode.safe.lowPerformance;


/**
 * synchronized 锁住所有代码块 或 锁住整个方法
 *
 * 低效率
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
     *
     * 1902102109
     * 1902102109
     * 1902102109
     *
     */
}
