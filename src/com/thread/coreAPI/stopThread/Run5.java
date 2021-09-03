package com.thread.coreAPI.stopThread;

/**
 * interrupt()方法并不能停止线程，结合isInterrupted()进行线程运行逻辑的处理 或者 抛异常的方法来对线程进行 停止控制
 */
public class Run5 {
    public static void main(String[] args) {
        try {
            MyThread3 thread = new MyThread3();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }
    /**
     * i = 282999
     * i = 283000
     * i = 283001
     * i = 283002
     * i = 283003
     * end!
     * 已经是停止状态了！我要退出了！
     * 我被输出，如果此代码是for又继续运行，线程并未停止！
     *
     */
}
