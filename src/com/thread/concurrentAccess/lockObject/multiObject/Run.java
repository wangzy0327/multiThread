package com.thread.concurrentAccess.lockObject.multiObject;

/**
 *
 * 多个对象多个锁
 *
 * 两个线程分别访问同一个类的两个不同实例的相同名称的同步方法
 *
 * 关键字synchronized取得的锁都是对象锁，而不是把一段代码或方法（函数）当作锁
 *
 * 如果多个线程访问多个对象，则JVM会创建多个锁。该例就创建了2个锁。
 *
 * 只有共享资源的读写访问才需要同步化，如果不是共享资源，那么没有同步的必要。
 *
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        ThreadA athread = new ThreadA(numRef1);
        athread.start();
        ThreadB bthread = new ThreadB(numRef2);
        bthread.start();
    }
    /*
    异步
    a set over!
    b set over!
    b num= 200
    a num= 100
     */
}
