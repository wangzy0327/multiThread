package com.thread.coreAPI.stopThread;

public class Run3 {
    public static void main(String[] args) {
        /**
         * isInterrupted() 不是static的
         * 判断线程是否停止，且不清楚状态标志.
         *
         */

        /**
         * interrupted()与isInterrupted()区别：
         * interrupted() 为静态方法，判断<当前线程></当前线程>是否是停止的，且会清除 停止状态标志
         * isInterrupted() 为普通方法(实例方法)，判断<线程Thread对象></线程Thread对象>是否是停止的，且不会清除 停止状态标志
         *
         */
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否停止 1 ？ = "+thread.isInterrupted());
            System.out.println("是否停止 2 ？ = "+thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
