package com.thread.coreAPI.stopThread.stop;

/**
 * stop() 方法已经被作废，因为如果强制让线程停止则有可能使一些清理性的工作得不到完成。
 * 另外一个情况就是 对锁定的对象进行了”解锁“，导致数据得不到同步的处理，出现数据不一致的问题。
 */
public class Run2 {
    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        thread.start();

        /**
         * 进入了catch()方法!
         * java.lang.ThreadDeath
         * 	at java.lang.Thread.stop(Thread.java:853)
         */
    }
}
