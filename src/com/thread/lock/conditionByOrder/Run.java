package com.thread.lock.conditionByOrder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用Condition对象对线程执行的业务进行排序规划。
 *
 */
public class Run {
    volatile private static int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread threadA = new Thread(){
            @Override
            public void run(){
                try {
                    lock.lock();
                    while(nextPrintWho != 1){
                        conditionA.await();
                    }
                    for(int i = 0;i < 3;i++){
                        System.out.println(Thread.currentThread().getName()+" ThreadA "+(i+1));
                    }
                    nextPrintWho = 2;
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread threadB = new Thread(()->{
            try {
                lock.lock();
                while(nextPrintWho != 2){
                    conditionB.await();
                }
                for(int i = 0;i < 3;i++){
                    System.out.println(Thread.currentThread().getName()+" ThreadB "+(i+1));
                }
                nextPrintWho = 3;
                conditionC.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread threadC = new Thread(()->{
            try {
                lock.lock();
                while(nextPrintWho != 3){
                    conditionC.await();
                }
                for(int i = 0;i < 3;i++){
                    System.out.println(Thread.currentThread().getName()+" ThreadC "+(i+1));
                }
                nextPrintWho = 1;
                conditionA.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        int num = 5;
        Thread[] aArray = new Thread[num];
        Thread[] bArray = new Thread[num];
        Thread[] cArray = new Thread[num];
        for(int i = 0;i < 5;i++){
            aArray[i] = new Thread(threadA);
            bArray[i] = new Thread(threadB);
            cArray[i] = new Thread(threadC);
            aArray[i].setName("threadA-"+(i+1));
            bArray[i].setName("threadB-"+(i+1));
            cArray[i].setName("threadC-"+(i+1));
            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }

    }

    /**
     * threadA-1 ThreadA 1
     * threadA-1 ThreadA 2
     * threadA-1 ThreadA 3
     * threadB-3 ThreadB 1
     * threadB-3 ThreadB 2
     * threadB-3 ThreadB 3
     * threadC-3 ThreadC 1
     * threadC-3 ThreadC 2
     * threadC-3 ThreadC 3
     * threadA-2 ThreadA 1
     * threadA-2 ThreadA 2
     * threadA-2 ThreadA 3
     * threadB-2 ThreadB 1
     * threadB-2 ThreadB 2
     * threadB-2 ThreadB 3
     * threadC-4 ThreadC 1
     * threadC-4 ThreadC 2
     * threadC-4 ThreadC 3
     * threadA-5 ThreadA 1
     * threadA-5 ThreadA 2
     * threadA-5 ThreadA 3
     * threadB-1 ThreadB 1
     * threadB-1 ThreadB 2
     * threadB-1 ThreadB 3
     * threadC-1 ThreadC 1
     * threadC-1 ThreadC 2
     * threadC-1 ThreadC 3
     * threadA-3 ThreadA 1
     * threadA-3 ThreadA 2
     * threadA-3 ThreadA 3
     * threadB-4 ThreadB 1
     * threadB-4 ThreadB 2
     * threadB-4 ThreadB 3
     * threadC-2 ThreadC 1
     * threadC-2 ThreadC 2
     * threadC-2 ThreadC 3
     * threadA-4 ThreadA 1
     * threadA-4 ThreadA 2
     * threadA-4 ThreadA 3
     * threadB-5 ThreadB 1
     * threadB-5 ThreadB 2
     * threadB-5 ThreadB 3
     * threadC-5 ThreadC 1
     * threadC-5 ThreadC 2
     * threadC-5 ThreadC
     *
     *
     */
}
