package com.thread.lock.condition;

/**
 *采用Condition实现 等待/通知模式
 *
 * 注意：必须在condition.await()方法调用之前调用lock.lock()代码获得同步监视器
 *  否则报错 监视器出错
 * await 时间为：1631242295301
 * Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
 * 	at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(ReentrantLock.java:151)
 * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(AbstractQueuedSynchronizer.java:1261)
 * 	at java.util.concurrent.locks.ReentrantLock.unlock(ReentrantLock.java:457)
 *
 * Object类中的wait()方法 相当于 Condition类中的await()方法
 * Object类中的wait(long timeout)方法相当于Condition类中的await(long time,TimeUnit unit)方法
 * Object类中的notify()方法相当于Condition类中的signal()方法
 * Object类中的notifyAll()方法相当于Condition类中的signalAll()方法
 *
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.start();
        Thread.sleep(3000);
        myService.signal();
    }

    /**
     *
     * await 时间为：1631242051052
     * signal 时间为：1631242054053
     *
     */
}
