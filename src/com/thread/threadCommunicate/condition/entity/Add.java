package com.thread.threadCommunicate.condition.entity;

//加法
public class Add {
    private String lock;
    public Add(String lock){
        super();
        this.lock = lock;
    }
    public void add(){
        synchronized (lock){
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
