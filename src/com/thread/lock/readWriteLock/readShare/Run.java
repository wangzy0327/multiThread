package com.thread.lock.readWriteLock.readShare;

/**
 *
 * 读锁共享
 */
public class Run {
    private volatile static Service service = new Service();
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            service.read();
        });
        Thread b = new Thread(()->{
            service.read();
        });
        a.setName("A");
        b.setName("B");
        a.start();
        b.start();
    }

    /**
     * 可知： A 和 B 是同时获得 读锁的
     * 获得读锁 B 1631417202583
     * 获得读锁 A 1631417202583
     *
     */
}
