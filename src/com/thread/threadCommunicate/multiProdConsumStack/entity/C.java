package com.thread.threadCommunicate.multiProdConsumStack.entity;

import com.thread.threadCommunicate.multiProdConsumStack.MyStack;

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
