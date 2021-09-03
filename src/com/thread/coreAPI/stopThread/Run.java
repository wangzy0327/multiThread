package com.thread.coreAPI.stopThread;

/**
 * java 中3种方法终止正在运行的线程：
 * 1）使用退出标志，使线程正常退出，也就是当run方法完成后线程终止
 * 2）使用stop方法强行终止线程，但是不推荐。因为stop、suspend及resume一样，都是作废过期的方法，使用可能产生不可预料的结果
 * 3）使用interrupt方法中断线程。
 *
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            //interrupted 静态方法
//            System.out.println("是否停止 1 ? = "+thread.interrupted());
//            System.out.println("是否停止 2 ? = "+thread.interrupted());

            /**
             *
             * i = 208042
             * i = 208043
             * i = 208044
             * 是否停止 1 ? = false
             * i = 208045
             * i = 208046
             * i = 208047
             * i = 208048
             * ...
             * ...
             * i = 208084
             * i = 208085
             * i = 208086
             * 是否停止 2 ? = false
             * i = 208087
             * i = 208088
             * i = 208089
             */

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
