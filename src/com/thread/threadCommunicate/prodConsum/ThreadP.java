package com.thread.threadCommunicate.prodConsum;

import com.thread.threadCommunicate.prodConsum.entity.P;

//生产者线程
public class ThreadP extends Thread{
    private P p;

    public ThreadP(P p){
        super();
        this.p = p;
    }

    @Override
    public void run(){
        while(true){
            p.setValue();
        }
    }

}
