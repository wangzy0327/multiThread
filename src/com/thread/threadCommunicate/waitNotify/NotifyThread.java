package com.thread.threadCommunicate.waitNotify;

public class NotifyThread extends Thread{
    private Object lock;
    public NotifyThread(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run(){
        Service service = new Service();
        service.synNotifyMethod(lock);
    }
}
