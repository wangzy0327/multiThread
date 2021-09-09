package com.thread.threadCommunicate.multiProdConsumStack.entity;

import com.thread.threadCommunicate.multiProdConsumStack.MyStack;

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
