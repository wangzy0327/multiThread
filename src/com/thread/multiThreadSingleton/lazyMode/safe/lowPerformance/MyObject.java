package com.thread.multiThreadSingleton.lazyMode.safe.lowPerformance;

/**
 * 安全的 懒汉模式 synchronized锁住方法 或 全部代码块
 *  --------低性能---------------
 *
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject(){}

//    synchronized public static MyObject getInstance(){
//        try {
//            if(myObject == null){
//                //模拟在创建对象之前做一些准备性工作
//                Thread.sleep(2000);
//                myObject = new MyObject();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return myObject;
//    }


    /**
     * 等同于锁住整个方法，全部代码被上锁
     * @return
     */
    public static MyObject getInstance(){
        try {
            synchronized(MyObject.class){
                if(myObject == null){
                    //模拟在创建对象之前做一些准备性工作
                    Thread.sleep(2000);
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }

}
