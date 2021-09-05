package com.thread.concurrentAccess.volatileSync.visibility;


/**
 *
 * 关键字synchronized可以使多个线程访问同一个资源具有同步性，而且它还具有将线程工作内存中
 * 的私有变量与公共内存中的变量同步的功能，在此实验中进行验证。
 *
 * synchronized代码块有volatile同步的功能
 *
 * 运行此程序时，以-server服务器模式进行运行
 *
 * 1、没加同步时，线程停不下来，陷入死循环，原因是各线程间的数据值没有可视性造成的
 * 2、加volatile，保证线程每次获取变量值时是从共享内存中获取到最新的值 更新到 线程的工作内存中
 * 3、关键字synchronized可以具有可视性。它包含两个特性：互斥性和可见性。同步synchronized不仅可以解决
 *   一个线程看到对象处于不一致的状态，还可以保证进入同步犯法或者同步代码块的每个线程，都看到由同一个锁保护之前
 *   所有的修改效果。
 *
 */
public class Run {
    public static void main(String[] args) {
        try {
            Service service = new Service();
            ThreadA a = new ThreadA(service);
            a.start();
            Thread.sleep(1000);
            ThreadB b = new ThreadB(service);
            b.start();
            System.out.println("已经发起停止的命令了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 情况1：
     * 已经发起停止的命令了！
     *   死循环 ...
     */

    /**
     * 情况2：volatile
     * 已经发起停止的命令了！
     * 停下来了！
     */


    /**
     * 情况2：synchronized 同步代码块
     * 已经发起停止的命令了！
     * 停下来了！
     */

}
