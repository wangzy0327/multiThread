package com.thread.coreAPI.stopThread.exception;

/**
 * 能停止的线程 —— 异常法
 */
public class Run6 {
    public static void main(String[] args) {
        try {
            MyThread4 thread = new MyThread4();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
//        for(int i = 0;i < 500000;i++)
//            System.out.println("main : i = "+(i+1));
        System.out.println("end!");
    }
}
