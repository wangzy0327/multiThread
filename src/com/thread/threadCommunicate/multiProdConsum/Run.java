package com.thread.threadCommunicate.multiProdConsum;

import com.thread.threadCommunicate.multiProdConsum.entity.C;
import com.thread.threadCommunicate.multiProdConsum.entity.P;

/**
 * 多生产与多消费：操作值 —— 假死
 *
 * "假死"的现象其实就是线程进入WAITING等待状态。如果全部线程都进入WAITING状态，则程序就不再执行任何业务功能了，整个项目呈停止状态。
 *
 *  如果使用notify()则有可能每次唤醒的是同类，程序一直不往下执行，出现“假死”
 *
 *  如果不使用while而用if，则有可能出现，多次是同类取到锁，而且从wait()断点后继续执行，而不进行判断，则
 *          可能连续 生产多次
 *          也有可能出现连续消费多次
 *           不能保证一次生产一次消费
 *
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        int num = 2;
        ThreadP[] pThread = new ThreadP[num];
        ThreadC[] cThread = new ThreadC[num];
        for(int i = 0;i < num;i++){
            pThread[i] = new ThreadP(p);
            pThread[i].setName("生产者 "+(i+1));
            cThread[i] = new ThreadC(c);
            cThread[i].setName("消费者 "+(i+1));
            pThread[i].start();
            cThread[i].start();
        }
        Thread.sleep(3000);
        Thread[] threadArr = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArr);
        for(int i = 0;i < threadArr.length;i++){
            System.out.println(threadArr[i].getName()+ " "
            +threadArr[i].getState());
        }
    }

    /**
     *if while 多次消费或生产
     *
     * 消费者 消费者 01 RUNNABLE了☆
     * 消费者 消费者 01 WAITING了☆
     * 消费者 消费者 11 RUNNABLE了☆
     * 消费者 消费者 11 WAITING了☆
     * 生产者 生产者 01 RUNNABLE了★
     * 生产者 生产者 01 WAITING了★
     * 消费者 消费者 11 RUNNABLE了☆
     * 消费者 消费者 11 WAITING了☆
     * 消费者 消费者 01 RUNNABLE了☆
     * 消费者 消费者 01 WAITING了☆
     * ...
     * ...
     *
     *
     */


    /**
     * notify()  notifyAll() 假死
     *消费者 消费者 01 RUNNABLE了☆
     * 消费者 消费者 01 WAITING了☆
     * 生产者 生产者 01 RUNNABLE了★
     * 生产者 生产者 01 WAITING了★
     * 生产者 生产者 11 WAITING了★
     * 消费者 消费者 11 RUNNABLE了☆
     * 消费者 消费者 11 WAITING了☆
     * 消费者 消费者 01 WAITING了☆
     * main RUNNABLE
     * Monitor Ctrl-Break RUNNABLE
     * 生产者 01 WAITING
     * 消费者 01 WAITING
     * 生产者 11 WAITING
     * 消费者 11 WAITING
     *
     */


}
