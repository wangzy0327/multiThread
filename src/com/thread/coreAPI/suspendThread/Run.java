package com.thread.coreAPI.suspendThread;

/**
 * suspend 和 resume 不建议使用
 * 从控制台打印的时间上来看，线程的确被暂停了，而且还可以恢复成运行的状态
 *
 * suspend 与 resume 方法的缺点 —— 独占
 * suspend 与 resume 方法的缺点 —— 不同步
 *
 * 在使用suspend 与 resume 方法时，如果使用不当，极易造成公共的同步对象的独占，
 * 使得其他线程无法访问公共同步对象
 *
 *
 */

public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(5000);
            //A段
            thread.suspend();
            System.out.println("A= "+System.currentTimeMillis()+" i= "
                                +thread.getI());
            Thread.sleep(5000);
            System.out.println("A= "+System.currentTimeMillis()+" i= "
                    +thread.getI());

            //B段
            thread.resume();
            Thread.sleep(5000);

            //C段
            thread.suspend();
            System.out.println("B= "+System.currentTimeMillis()+" i= "
                    +thread.getI());
            Thread.sleep(5000);
            System.out.println("B= "+System.currentTimeMillis()+" i= "
                    +thread.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         *
         * A= 1630573764104 i= 3282426218
         * A= 1630573769116 i= 3282426218
         * B= 1630573774129 i= 6577296632
         * B= 1630573779144 i= 6577296632
         *
         */
    }
}
