package com.thread.concurrentAccess.synchronizedFunc;

public class ThreadA2 extends Thread{
    private MyObject object;
    public ThreadA2(MyObject object){
        super();
        this.object = object;
    }
    @Override
    public void run(){
        super.run();
        object.methodA();
    }
}
