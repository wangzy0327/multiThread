package com.thread.threadCommunicate.waitNotify;

public class Service {
    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin wait() ThreadName = "+
                        Thread.currentThread().getName());
//                lock.wait();
                //将wait()修改为sleep()，就成了同步的效果，sleep()不释放锁
                Thread.sleep(2000);
                System.out.println(" end wait() ThreadName = "+
                        Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void synNotifyMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin notify() ThreadName = "
                        +Thread.currentThread().getName() + " time = "
                        +System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("  end notify() ThreadName = "
                        +Thread.currentThread().getName() + " time = "
                        +System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
