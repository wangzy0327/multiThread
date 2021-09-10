package com.thread.lock.reentrantLockSync;

/**
 * 使用ReentrantLock 实现同步
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThread a1 = new MyThread(myService);
        MyThread a2 = new MyThread(myService);
        MyThread a3 = new MyThread(myService);
        MyThread a4 = new MyThread(myService);
        MyThread a5 = new MyThread(myService);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();


        /**
         *
         * 调用ReentrantLock对象的lock()方法获取锁，调用unlock方法释放锁
         * 可以发现打印的内容是同步的，默认ReentrantLock对象创建的是非公平锁
         * 所以先创建的可运行状态的线程不一定先执行。
         *
         * ThreadName = Thread-2 1
         * ThreadName = Thread-2 2
         * ThreadName = Thread-2 3
         * ThreadName = Thread-2 4
         * ThreadName = Thread-2 5
         * ThreadName = Thread-0 1
         * ThreadName = Thread-0 2
         * ThreadName = Thread-0 3
         * ThreadName = Thread-0 4
         * ThreadName = Thread-0 5
         * ThreadName = Thread-1 1
         * ThreadName = Thread-1 2
         * ThreadName = Thread-1 3
         * ThreadName = Thread-1 4
         * ThreadName = Thread-1 5
         * ThreadName = Thread-4 1
         * ThreadName = Thread-4 2
         * ThreadName = Thread-4 3
         * ThreadName = Thread-4 4
         * ThreadName = Thread-4 5
         * ThreadName = Thread-3 1
         * ThreadName = Thread-3 2
         * ThreadName = Thread-3 3
         * ThreadName = Thread-3 4
         * ThreadName = Thread-3 5
         *
         */
    }
}
