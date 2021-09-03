package com.thread.coreAPI.stopThread.stop;

/**
 * 使用 stop() 停止线程 不推荐（已被标记为 过期方法）
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(8000);
            //使用stop()停止线程是非常暴力的
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
