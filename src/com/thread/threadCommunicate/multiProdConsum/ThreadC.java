package com.thread.threadCommunicate.multiProdConsum;

import com.thread.threadCommunicate.multiProdConsum.entity.C;

//消费者线程
public class ThreadC extends Thread{
    private C c;

    public ThreadC(C c){
        super();
        this.c = c;
    }

    @Override
    public void run(){
        while(true){
            c.getValue();
        }
    }
}
