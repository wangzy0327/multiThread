package com.thread.concurrentAccess.synchronizedClass;


/**
 *
 * 异步的原因是持有不同的锁，一个是对象锁，另外一个是Class锁，而Class锁可以对类的所有对象实例起作用。
 *
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        ThreadC c = new ThreadC(service);
        c.setName("C");
        c.start();
    }

    /**
     线程名称为：A在1631087445977进入printA
     线程名称为：C在1631087445980进入printC
     线程名称为：C在1631087445980离开printC
     线程名称为：A在1631087448985离开printA
     线程名称为：B在1631087448985进入printB
     线程名称为：B在1631087448985离开printB
     */
}
