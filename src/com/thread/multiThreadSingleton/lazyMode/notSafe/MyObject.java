package com.thread.multiThreadSingleton.lazyMode.notSafe;

/**
 * 非安全的 懒汉模式
 *
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject(){}

    public static MyObject getInstance(){
        if(myObject == null){
            myObject = new MyObject();
        }
        return myObject;
    }
}
