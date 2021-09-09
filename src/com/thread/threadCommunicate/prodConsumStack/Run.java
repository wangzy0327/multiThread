package com.thread.threadCommunicate.prodConsumStack;

import com.thread.threadCommunicate.prodConsumStack.entity.C;
import com.thread.threadCommunicate.prodConsumStack.entity.P;

/**
 * 一生产者与一消费： 操作栈
 *
 * 容器size()的值不会大于1
 *
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        PThread pThread = new PThread(p);
        CThread cThread = new CThread(c);
        pThread.start();
        cThread.start();
    }

    /**
     * pop=anyString = 0.23348435775501541
     * pop操作中的：Thread-1 线程呈wait状态
     * push=1
     * pop=0
     * pop=anyString = 0.9599785907880746
     * push=1
     * pop=0
     * pop=anyString = 0.5895689648813681
     * push=1
     * pop=0
     * pop=anyString = 0.04100988624565172
     * push=1
     * pop=0
     * pop=anyString = 0.09237205148930283
     * push=1
     * pop=0
     * pop=anyString = 0.6267377320649835
     * push=1
     * pop=0
     * pop=anyString = 0.013685778447222297
     * push=1
     * pop=0
     * pop=anyString = 0.2748360360391382
     * push=1
     * pop=0
     * pop=anyString = 0.4171649680092874
     * push=1
     * pop=0
     *
     *
     */
}
