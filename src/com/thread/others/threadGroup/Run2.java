package com.thread.others.threadGroup;

public class Run2 {
    public static void main(String[] args) {
        System.out.println("线程："+Thread.currentThread().getName()+"所在的线程组名为："+Thread.currentThread().getThreadGroup().getName());
        System.out.println("main线程所在的线程组的父线程组的名称是："+Thread.currentThread().getThreadGroup().getParent().getName());
        System.out.println("main线程所在的线程组的父线程组的父线程组的名称是："+Thread.currentThread().getThreadGroup().getParent().getParent().getName());
    }

    /**
     * 线程：main所在的线程组名为：main
     * main线程所在的线程组的父线程组的名称是：system
     * main线程所在的线程组的父线程组的父线程组的名称是：system
     *
     */
}
