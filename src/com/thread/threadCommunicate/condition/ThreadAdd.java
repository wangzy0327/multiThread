package com.thread.threadCommunicate.condition;

import com.thread.threadCommunicate.condition.entity.Add;

public class ThreadAdd extends Thread{
    private Add p;
    public ThreadAdd(Add p){
        super();
        this.p = p;
    }

    @Override
    public void run(){
        p.add();
    }
}
