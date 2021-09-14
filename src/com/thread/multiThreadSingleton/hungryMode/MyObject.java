package com.thread.multiThreadSingleton.hungryMode;

/**
 *
 * 饿汉模式
 */
public class MyObject {
    //立即加载方式 === 饿汉模式
    private static MyObject myObject = new MyObject();
    private MyObject(){}

    public static MyObject getInstance(){
        //此代码版本为立即加载
        //缺点是不能有其他实例变量
        return myObject;
    }

}
