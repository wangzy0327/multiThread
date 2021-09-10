package com.thread.lock.multiProdConsum;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set(){
        try {
            lock.lock();

            while (hasValue == true){
                System.out.println(Thread.currentThread().getName()+"  "+"有可能 set ★★连续 start");
                condition.await();
                System.out.println(Thread.currentThread().getName()+"  "+"有可能 set ★★连续 end");
            }
            System.out.println(Thread.currentThread().getName()+"  "+"set 打印★");
            hasValue = true;
//            condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while(hasValue == false){
                System.out.println(Thread.currentThread().getName()+"  "+"有可能 get ☆☆连续 start");
                condition.await();
                System.out.println(Thread.currentThread().getName()+"  "+"有可能 get ☆☆连续 end");
            }
            System.out.println(Thread.currentThread().getName()+"  "+"get 打印☆");
            hasValue = false;
//            condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
