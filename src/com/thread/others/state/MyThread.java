package com.thread.others.state;

public class MyThread extends Thread{
    @Override
    public void run(){
        try {
            synchronized (Lock.lock){
                Lock.lock.wait(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
