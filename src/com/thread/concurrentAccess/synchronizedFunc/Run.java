package com.thread.concurrentAccess.synchronizedFunc;

public class Run {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }

    /**
     * 不加synchronized()
     * 两个线程可以进入同一个方法
     *
     * begin methodA threadName = A
     * begin methodA threadName = B
     * end
     * end
     *
     */

    /**
     * 加synchronized()
     * 调用synchronized()声明的方法 一定是排队运行的。
     *
     *
     * begin methodA threadName = A
     * end
     * begin methodA threadName = B
     * end
     *
     */
}
