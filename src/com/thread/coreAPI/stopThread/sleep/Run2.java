package com.thread.coreAPI.stopThread.sleep;



/**
 * 在沉睡中 被 停止
 *
 * 先停止，再遇到了sleep
 *
 */
public class Run2 {
    public static void main(String[] args) {
        MyThread6 thread = new MyThread6();
        thread.start();
        thread.interrupt();
        System.out.println("end!");
    }
    /**
     end!
     ...
     ...
     i=999991
     run begin!
     先停止，再遇到了sleep！进入catch！false
     java.lang.InterruptedException: sleep interrupted
     */
}
