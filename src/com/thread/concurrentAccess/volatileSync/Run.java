package com.thread.concurrentAccess.volatileSync;

/**
 * volatile不保证原子性
 */
public class Run {
    public static void main(String[] args) {
        MyThread[] mythreadArray = new MyThread[100];
        for(int i = 0;i < 100;i++){
            mythreadArray[i] = new MyThread();
            mythreadArray[i].setName(("Thread-"+i));
        }
        for(int i = 0;i < 100;i++){
            mythreadArray[i].start();
        }
    }

    /**
     * 加了synchronized
     * count = 10000
     * count = 9900
     * count = 9731
     * count = 9731
     * count = 9510
     * count = 9312
     * count = 9312
     * count = 9100
     * count = 8890
     * count = 8500
     *
     */
}
