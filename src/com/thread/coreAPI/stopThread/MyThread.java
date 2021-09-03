package com.thread.coreAPI.stopThread;

public class MyThread extends Thread{
    @Override
    public void run(){
        super.run();
        for(int i = 0;i < 500000;i++){
//            if(i == 250000 || i == 250001){
//                Thread.currentThread().interrupt();
//                System.out.println("是否停止 "+i+" ? = "+Thread.interrupted()+" stop : "+System.currentTimeMillis());
//            }
            System.out.println("i = "+(i + 1)+" timestamp :"+System.currentTimeMillis());
        }
    }

    /**
     i = 249997 timestamp :1630481325240
     i = 249998 timestamp :1630481325240
     i = 249999 timestamp :1630481325240
     i = 250000 timestamp :1630481325240
     是否停止 250000 ? = true stop : 1630481325240
     i = 250001 timestamp :1630481325240
     是否停止 250001 ? = true stop : 1630481325240
     i = 250002 timestamp :1630481325240
     i = 250003 timestamp :1630481325240
     i = 250004 timestamp :1630481325240
     i = 250005 timestamp :1630481325240
     *
     */
}
