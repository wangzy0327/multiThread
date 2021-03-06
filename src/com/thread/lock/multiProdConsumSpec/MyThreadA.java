package com.thread.lock.multiProdConsumSpec;

public class MyThreadA extends Thread{
    private com.thread.lock.multiProdConsumSpec.MyService myService;

    public MyThreadA(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run(){
        for(int i = 0;i < Integer.MAX_VALUE;i++)
            myService.set();
    }
}
