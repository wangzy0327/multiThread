package com.thread.threadCommunicate.condition;

import com.thread.threadCommunicate.condition.entity.Subtract;

public class ThreadSubtract extends Thread{
    private Subtract r;
    public ThreadSubtract(Subtract r){
        super();
        this.r = r;
    }

    @Override
    public void run(){
        r.substract();
    }
}
