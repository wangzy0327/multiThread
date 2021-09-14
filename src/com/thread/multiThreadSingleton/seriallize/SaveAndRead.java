package com.thread.multiThreadSingleton.seriallize;

import java.io.*;


/**
 *
 * 反序列化 单例模式 创建 了 多个对象 解决
 *
 * readResolve()
 *
 *
 若目标类有readResolve方法，那就通过反射的方式调用要被反序列化的类中的readResolve方法，返回一个对象，
 然后把这个新的对象复制给之前创建的obj（即最终返回的对象）。
 那被反序列化的类中的readResolve 方法里是什么？就是直接返回我们的单例对象
 *
 */
public class SaveAndRead {
    public static void main(String[] args) {
        try {
            MyObject myObject = MyObject.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File("myObjectFile.txt"));
            ObjectOutputStream oosRef  = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fisRef = new FileInputStream(new File("myObjectFile.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            MyObject myObject = (MyObject) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println(myObject.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * 不解决的话
     *
     * 2133927002
     * 931919113
     *
     */


    /**
     * 采用 readResolve 解决
     *
     * 2133927002
     * 调用了readResolve方法
     * 2133927002
     *
     */
}
