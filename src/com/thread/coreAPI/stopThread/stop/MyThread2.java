package com.thread.coreAPI.stopThread.stop;

/**
 * 调用stop()方法时会抛出java.lang.ThreadDeath异常
 */
public class MyThread2 extends Thread{
    @Override
    public void run(){
        try {
            this.stop();
        } catch (ThreadDeath e) {
            System.out.println("进入了catch()方法!");
            e.printStackTrace();
        }
    }
}
