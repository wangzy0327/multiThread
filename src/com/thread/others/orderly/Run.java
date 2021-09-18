package com.thread.others.orderly;

public class Run {
    /**
     *  打印3批 ABC 字母
     *  每个线程只打印自己的 字母
     *  通过 volatile 标识 有序控制 从1-9
     *
     *  采用Synchronized利用volatile 进行 打印的 有序控制，当然也可以采用ReentrantLock - Condition 进行精确唤醒
     * @param args
     */
    public static void main(String[] args) {
        Object lock = new Object();
        MyThread a = new MyThread(lock,"A",1);
        MyThread b = new MyThread(lock,"B",2);
        MyThread c = new MyThread(lock,"C",0);
        a.start();
        b.start();
        c.start();

        /**
         *
         * ThreadName = Thread-0 runCount = 1 A
         * ThreadName = Thread-1 runCount = 2 B
         * ThreadName = Thread-2 runCount = 3 C
         * ThreadName = Thread-0 runCount = 4 A
         * ThreadName = Thread-1 runCount = 5 B
         * ThreadName = Thread-2 runCount = 6 C
         * ThreadName = Thread-0 runCount = 7 A
         * ThreadName = Thread-1 runCount = 8 B
         * ThreadName = Thread-2 runCount = 9 C
         *
         *
         */
    }
}
