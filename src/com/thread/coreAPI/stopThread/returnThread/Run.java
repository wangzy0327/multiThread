package com.thread.coreAPI.stopThread.returnThread;


/**
 * 使用return停止线程。
 *
 * 不过还是建议使用“抛异常”法来实现线程的停止，
 * 因为在catch块中可以对异常的信息进行相关的处理，而且使用异常流能更好、
 * 更方便地控制程序的运行流程，不至于代码中出现很多个return;造成污染。
 *
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread t = new MyThread();
            t.start();
            Thread.sleep(2000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * timer = 1630571965881
     * timer = 1630571965881
     * timer = 1630571965881
     * timer = 1630571965881
     * 停止了！
     *
     */
}
