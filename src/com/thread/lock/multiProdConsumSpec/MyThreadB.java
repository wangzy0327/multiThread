package com.thread.lock.multiProdConsumSpec;

public class MyThreadB extends Thread{
    private com.thread.lock.multiProdConsumSpec.MyService myService;

    public MyThreadB(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run(){
        for(int i = 0;i < Integer.MAX_VALUE;i++)
            myService.get();
    }
}
