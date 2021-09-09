package com.thread.threadCommunicate.multiProdConsumStack;

import com.thread.threadCommunicate.multiProdConsumStack.entity.C;
import com.thread.threadCommunicate.multiProdConsumStack.entity.P;

/**
 * 多生产者与多消费者： 操作栈
 *
 * 容器size()的值不会大于1
 *
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        P p5 = new P(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);
        C c5 = new C(myStack);
        PThread pThread1 = new PThread(p1);
        PThread pThread2 = new PThread(p2);
        PThread pThread3 = new PThread(p3);
        PThread pThread4 = new PThread(p4);
        PThread pThread5 = new PThread(p5);
        CThread cThread1 = new CThread(c1);
        CThread cThread2 = new CThread(c2);
        CThread cThread3 = new CThread(c3);
        CThread cThread4 = new CThread(c4);
        CThread cThread5 = new CThread(c5);

        pThread1.start();
        pThread2.start();
        pThread3.start();
        pThread4.start();
        pThread5.start();

        cThread1.start();
        cThread2.start();
        cThread3.start();
        cThread4.start();
        cThread5.start();
    }

    /**
     push=1
     pop=0
     pop=anyString = 0.3832286015550659
     pop操作中的：Thread-6 线程呈wait状态
     push=1
     pop=0
     pop=anyString = 0.9959334781989139
     pop操作中的：Thread-8 线程呈wait状态
     pop操作中的：Thread-5 线程呈wait状态
     push=1
     pop=0
     pop=anyString = 0.41114797545670057
     pop操作中的：Thread-5 线程呈wait状态
     pop操作中的：Thread-8 线程呈wait状态
     pop操作中的：Thread-9 线程呈wait状态
     push=1
     pop=0
     pop=anyString = 0.827799177188899
     pop操作中的：Thread-7 线程呈wait状态
     *
     *
     */
}
