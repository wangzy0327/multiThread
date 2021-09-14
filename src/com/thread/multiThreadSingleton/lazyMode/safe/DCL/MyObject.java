package com.thread.multiThreadSingleton.lazyMode.safe.DCL;

/**
 *
 * 懒汉模式 - 单例
 * 双重检验锁
 */
public class MyObject {

    //这里的volatile 保证 myObject的可见性、已经 new myObject过程中保证 操作的有序性，采用内存屏障 防止指令重排
    // 1、开辟内存空间
    // 2. 创建内存对象
    // 3. 将创建的内存对象 引用赋值给 变量

    //创建对象的过程分为以上三步，非原子性的，在进行运算时，可能会发生指令重排
    private volatile static MyObject myObject;

    private MyObject(){}

    public static MyObject getInstance(){
        try {
            if(myObject == null){
                //模拟对象创建前的准备工作
                Thread.sleep(2000);
                synchronized (MyObject.class){
                    //这里需要二次检验 因为在进入synchronized进行了myObject的检查，但是存在等待锁的过程中，myObject对象已经创建成功，所以要
                    //二次检验
                    if(myObject == null){
                        myObject = new MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }

}
