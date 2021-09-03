package com.thread.concurrentAccess.synchronizedFunc;

public class ThreadB2 extends Thread{
    private MyObject object;
    public ThreadB2(MyObject object){
        super();
        this.object = object;
    }
    @Override
    public void run(){
        super.run();
        object.methodB();
    }
}
