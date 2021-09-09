package com.thread.threadCommunicate.prodConsumStack.entity;

import com.thread.threadCommunicate.prodConsumStack.MyStack;

public class C {
    private MyStack myStack;
    public C(MyStack myStack){
        super();
        this.myStack = myStack;
    }
    public void popService(){
        System.out.println("pop="+myStack.pop());
    }
}
