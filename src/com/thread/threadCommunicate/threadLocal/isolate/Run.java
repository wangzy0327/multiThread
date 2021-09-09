package com.thread.threadCommunicate.threadLocal.isolate;

/**
 * 验证线程变量的隔离性
 *
 * 三个线程都向 ThreadLocal中set()数据值，但是每个线程还是能取出自己的数据
 *
 * 原理：每个Thread对象里都有个 ThreadLocal.ThreadLocalMap threadLocals = null; 对象，
 *
 *  ThreadLocal {
 *     public T get() {
 *         Thread t = Thread.currentThread();
 *         ThreadLocalMap map = getMap(t);
 *         if (map != null) {
 *             ThreadLocalMap.Entry e = map.getEntry(this);
 *             if (e != null) {
 *                 @SuppressWarnings("unchecked")
 *                 T result = (T)e.value;
 *                 return result;
 *             }
 *         }
 *         return setInitialValue();
 *     }
 *
 *     public void set(T value) {
 *         Thread t = Thread.currentThread();
 *         ThreadLocalMap map = getMap(t);
 *         if (map != null)
 *             map.set(this, value);
 *         else
 *             createMap(t, value);
 *     }
 *
 *  }
 *
 */
public class Run {
    public static void main(String[] args) {
        try {
            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.start();
            b.start();
            for(int i = 0;i < 100;i++){
                Tools.t1.set("Main"+(i+1));
                System.out.println("Main get Value="
                        + Tools.t1.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
