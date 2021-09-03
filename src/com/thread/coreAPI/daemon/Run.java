package com.thread.coreAPI.daemon;

/**
 * Java线程中有两种线程： 用户线程，守护线程
 *
 * 守护线程是一种特殊的线程，特性有陪伴的含义，当进程中不存在非守护线程了，则守护线程自动销毁。
 *
 * 典型的守护线程就是垃圾回收线程，当进程中没有非守护线程了，则垃圾回收线程也就没有存在的必要了，自动销毁。
 *
 * 守护线程的作用就是为其他线程的运行提供便利服务，最典型的应用就是GC(垃圾回收器)，它就是一个很称职的守护者
 *
 *
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            //这里 main 线程是用户线程，创建的 thread线程 设置为 守护线程，当用户线程main退出时，守护线程也就退出了...
            System.out.println("我离开thread对象也不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
