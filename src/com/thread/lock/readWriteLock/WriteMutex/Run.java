package com.thread.lock.readWriteLock.WriteMutex;



/**
 *
 * 写写锁 互斥
 */
public class Run {
    private volatile static Service service = new Service();
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            service.write();
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
     * 写锁同一时间只允许一个线程执行lock()方法后面的代码
     *
     * 获得写锁 B 1631417538370
     * 获得写锁 A 1631417548371
     *
     */
}
