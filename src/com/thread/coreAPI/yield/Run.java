package com.thread.coreAPI.yield;

/**
 * yield() 是native，static方法的作用是放弃当前的CPU资源，将它让给其他的任务去占用CPU执行时间。
 * 但放弃的时间不确定，有可能刚刚放弃，马上又获得CPU时间片
 */
public class Run {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }

    /**
     *  no yield()
     *  CPU 独占时间片
     * 用时：20毫秒！
     *
     */

    /**
     * yield() 将CPU让给其他资源导致速度变慢
     * 用时：4955毫秒！
     */
}
