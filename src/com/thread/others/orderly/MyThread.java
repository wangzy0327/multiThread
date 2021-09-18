package com.thread.others.orderly;

public class MyThread extends Thread{
    private Object lock;
    private String showChar;
    private int showNumPosition;
    private int printCount = 0;//统计打印了几个字母
    volatile private static int addNumber = 1;
    public MyThread(Object lock,String showChar,int showNumPosition){
        super();
        this.lock = lock;
        this.showChar = showChar;
        this.showNumPosition = showNumPosition;
    }

    @Override
    public void run(){
        try {
            synchronized (lock){
                while(true){
                    while(addNumber%3 != showNumPosition){
                        lock.wait();
                    }
                    System.out.println("ThreadName = "+Thread.currentThread().getName()+" runCount = "+addNumber+" "+showChar);
                    addNumber++;
                    printCount++;
                    //注意一般 wait/ notifyAll() notifyAll()放在最后
                    lock.notifyAll();
                    if(printCount == 3)
                        break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
