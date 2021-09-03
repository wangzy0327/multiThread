package com.thread.concurrentAccess.synchronizedFunc;

/**
 * 结论：
 * 1）A线程先持有object对象的Lock锁，B线程可以以异步的方式调用object对象中的非synchronized类型的方法
 * 2）A线程先持有object对象的Lock锁，B线程如果在这时调用object对象中的synchronized类型的方法则需等待，也就是同步。
 *
 */
public class Run2 {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA2 a = new ThreadA2(object);
        a.setName("A");
        ThreadB2 b = new ThreadB2(object);
        b.setName("B");
        a.start();
        b.start();
    }

    /**
     *
     * methodB() 不加synchronized同步方法
     *  可以看到两个方法异步执行
         begin methodA threadName = A
         begin methodB threadName = B begin time = 1630652691463
         B end endTime = 1630652694473
         end
     *
     */

    /**
     * methodB() 加synchronized同步方法
     * 可以看到两个方法同步顺序执行
     *
     * begin methodA threadName = A
     * end
     * begin methodB threadName = B begin time = 1630652816992
     * B end endTime = 1630652819994
     *
     *
     */
}
