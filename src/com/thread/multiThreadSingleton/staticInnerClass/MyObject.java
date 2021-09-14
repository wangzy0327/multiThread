package com.thread.multiThreadSingleton.staticInnerClass;

/**
 * 采用静态内部类完成 单例模式
 *
 *  静态内部类保证在内存中只有一份（只加载一次）
 *
 *  利用静态内部类调用才去加载达到延时创建的目的
 *
 */
public class MyObject {

    private static class MyObjectInnerCls{
        private static MyObject object = new MyObject();
    }

    private MyObject(){}

    public static MyObject getInstance(){
        return MyObjectInnerCls.object;
    }

}
