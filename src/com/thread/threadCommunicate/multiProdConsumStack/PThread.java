package com.thread.threadCommunicate.multiProdConsumStack;

import com.thread.threadCommunicate.multiProdConsumStack.entity.P;

public class PThread extends Thread{
    private P p;
    public PThread(P p){
        super();
        this.p = p;
    }
    @Override
    public void run(){
        while(true){
            p.pushService();
        }
    }
}
