package com.thread.lock.readWriteLock.readWriteMutex;


/**
 *
 * 读写锁 互斥
 */
public class Run {
    private volatile static Service service = new Service();
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            service.read();
        });
        Thread b = new Thread(()->{
            service.write();
        });
        a.setName("A");
        b.setName("B");
        a.start();
        b.start();
    }

    /**
     *
     * 同一时间只允许 一个线程执行lock()后面的方法
     *
     * 获得写锁 B 1631417414041
     * 获得读锁 A 1631417424042
     *
     */
}
