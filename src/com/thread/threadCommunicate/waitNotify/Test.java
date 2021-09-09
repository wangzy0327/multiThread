package com.thread.threadCommunicate.waitNotify;

/**
 *
 * 方法notify()执行后不释放锁，必须执行完notify()方法所在的同步synchronized代码块后才释放锁
 */
public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();
    }

    /**
     *
     * begin wait() ThreadName = Thread-0
     * begin notify() ThreadName = Thread-1 time = 1631095757083
     *   end notify() ThreadName = Thread-1 time = 1631095762093
     *  end wait() ThreadName = Thread-0
     * begin notify() ThreadName = Thread-2 time = 1631095762093
     *   end notify() ThreadName = Thread-2 time = 1631095767095
     */


    /**
     * 替换wait()为sleep()就为同步效果，sleep()不释放锁
     * begin wait() ThreadName = Thread-0
     *  end wait() ThreadName = Thread-0
     * begin notify() ThreadName = Thread-2 time = 1631149235969
     *   end notify() ThreadName = Thread-2 time = 1631149240979
     * begin notify() ThreadName = Thread-1 time = 1631149240979
     *   end notify() ThreadName = Thread-1 time = 1631149245981
     *
     *
     */
}
