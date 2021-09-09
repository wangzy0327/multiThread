package com.thread.threadCommunicate.prodConsumStack;

import com.thread.threadCommunicate.prodConsumStack.entity.C;

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
