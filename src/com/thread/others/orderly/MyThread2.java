package com.thread.others.orderly;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread2 extends Thread{
    private ReentrantLock lock;
    private Condition cur;
    private Condition next;
    private String showChar;
    private int showNumPosition;
    private int printCount = 0;//统计打印了几个字母
    volatile private static int addNumber = 1;

    public MyThread2(ReentrantLock lock, Condition cur,Condition next, String showChar, int showNumPosition) {
        this.lock = lock;
        this.cur = cur;
        this.next = next;
        this.showChar = showChar;
        this.showNumPosition = showNumPosition;
    }

    @Override
    public void run(){

        while (true) {
            try {
                lock.lock();
                while (addNumber % 3 != showNumPosition) {
                    cur.await();
                }
                System.out.println("ThreadName = " + Thread.currentThread().getName() + " runCount = " + addNumber + " " + showChar);
                addNumber++;
                printCount++;
                //注意代码里 await/signalAll 搭配 ，signalAll一般放在最后
                next.signalAll();
                if (printCount == 3)
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        System.out.println(Thread.currentThread().getName() + " 跳出循环....");


    }

}
