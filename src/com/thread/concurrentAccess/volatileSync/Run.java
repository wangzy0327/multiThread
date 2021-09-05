package com.thread.concurrentAccess.volatileSync;

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
}
