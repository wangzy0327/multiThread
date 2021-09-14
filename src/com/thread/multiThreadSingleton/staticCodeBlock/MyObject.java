package com.thread.multiThreadSingleton.staticCodeBlock;

public class MyObject {
    private MyObject(){}
    private static MyObject myObject;
    static{
        myObject = new MyObject();
    }
    public static MyObject getInstance(){
        return myObject;
    }
}
