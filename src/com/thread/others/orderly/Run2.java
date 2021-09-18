package com.thread.others.orderly;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Run2 {
    /**
     *  打印3批 ABC 字母
     *  每个线程只打印自己的 字母
     *  通过 volatile 标识 有序控制 从1-9
     *
     *  采用ReentrantLock 和 Condition 搭配volatile 精确唤醒 进行 打印的 有序控制
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        MyThread2 a = new MyThread2(lock,c1,c2,"a",1);
        MyThread2 b = new MyThread2(lock,c2,c3,"b",2);
        MyThread2 c = new MyThread2(lock,c3,c1,"c",0);
        a.start();
        b.start();
        c.start();


        /**
         * ThreadName = Thread-0 runCount = 1 a
         * ThreadName = Thread-1 runCount = 2 b
         * ThreadName = Thread-2 runCount = 3 c
         * ThreadName = Thread-0 runCount = 4 a
         * ThreadName = Thread-1 runCount = 5 b
         * ThreadName = Thread-2 runCount = 6 c
         * ThreadName = Thread-0 runCount = 7 a
         * Thread-0 跳出循环....
         * ThreadName = Thread-1 runCount = 8 b
         * Thread-1 跳出循环....
         * ThreadName = Thread-2 runCount = 9 c
         * Thread-2 跳出循环....
         *
         */
    }
}
