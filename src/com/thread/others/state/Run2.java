package com.thread.others.state;

public class Run2 {
    //NEW
    //RUNNABLE
    //TERMINATED
    //BLOCKED
    //WAITING
    //TIMED_WAITING
    public static void main(String[] args) {
        try {
            Thread t1 = new Thread(()->{
                MyService.serviceMethod();
            });
            t1.setName("a");
            t1.start();
            //让t1先执行,等它1000ms
            t1.join(1000);
            Thread.sleep(1000);
            Thread t2 = new Thread(()->{
                MyService.serviceMethod();
            });
            t2.setName("b");
            t2.start();
            //让t2执行起来，等待500ms
            t2.join(500);
            System.out.println("main方法中的t2状态："+t2.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * a进入了业务方法！
     * main方法中的t2状态：BLOCKED
     * b进入了业务方法！
     *
     *
     */
}
