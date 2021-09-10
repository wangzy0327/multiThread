package com.thread.lock.reentrantLockSync;

public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();
        ThreadAA aa = new ThreadAA(myService);
        aa.setName("AA");
        aa.start();
        Thread.sleep(100);
        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();
        ThreadBB bb = new ThreadBB(myService);
        bb.setName("BB");
        bb.start();
    }
}
