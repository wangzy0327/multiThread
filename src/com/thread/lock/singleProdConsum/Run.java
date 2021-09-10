package com.thread.lock.singleProdConsum;


/**
 * 生产者/消费者  一对一交替打印
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA a = new MyThreadA(myService);
        MyThreadB b = new MyThreadB(myService);
        a.start();
        b.start();

    }

    /**
     *
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     * set 打印★
     * get 打印☆
     *
     */
}
