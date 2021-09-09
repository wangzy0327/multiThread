package com.thread.threadCommunicate.multiProdConsumStack;

import com.thread.threadCommunicate.multiProdConsumStack.entity.C;

public class CThread extends Thread{
    private C c;
    public CThread(C c){
        super();
        this.c = c;
    }
    @Override
    public void run(){
        while(true){
            c.popService();
        }
    }
}
