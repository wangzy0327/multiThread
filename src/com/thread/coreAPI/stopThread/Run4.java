package com.thread.coreAPI.stopThread;

public class Run4 {
    public static void main(String[] args) {
        try {
            MyThread2 thread = new MyThread2();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }
    /**
     *
     * i = 279184
     * i = 279185
     * i = 279186
     * i = 279187
     * end!
     * 已经是停止状态了！我要退出了！
     *
     */
}
