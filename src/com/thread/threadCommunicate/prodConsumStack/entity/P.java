package com.thread.threadCommunicate.prodConsumStack.entity;

import com.thread.threadCommunicate.prodConsumStack.MyStack;

public class P {
    private MyStack myStack;
    public P(MyStack myStack){
        super();
        this.myStack = myStack;
    }
    public void pushService(){
        myStack.push();
    }
}
