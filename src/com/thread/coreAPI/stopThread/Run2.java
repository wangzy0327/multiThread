package com.thread.coreAPI.stopThread;

public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        //interrupted 除了判断出当前线程是否是停止状态，而且 还 具有 清楚线程中断状态的功能
        //所以 第二次调用 返回值 是 false
        /**
         * 是否停止 1 ? = true
         * 是否停止 2 ? = false
         * end!
         */
        System.out.println("是否停止 1 ? = "+Thread.interrupted());
        System.out.println("是否停止 2 ? = "+Thread.interrupted());
        System.out.println("end!");
    }
}
