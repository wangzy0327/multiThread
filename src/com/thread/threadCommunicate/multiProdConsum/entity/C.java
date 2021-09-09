package com.thread.threadCommunicate.multiProdConsum.entity;

//消费者
public class C {
    private String lock;
    public C(String lock){
        super();
        this.lock = lock;
    }
    public void getValue(){
        try {
            synchronized (lock){
                //如果 valueObject容器里为空，则释放 通知 锁 wait
//                if(ValueObject.value.equals("")){
                while(ValueObject.value.equals("")){
                    System.out.println("消费者 "+Thread.currentThread().getName()+" WAITING了☆");
                    lock.wait();
                }
                System.out.println("消费者 "+Thread.currentThread().getName()+" RUNNABLE了☆");
//                System.out.println("get的值是 "+ ValueObject.value);
                ValueObject.value = "";
                //获取元素后，通知  等待的 生产者 线程
//                lock.notify();
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
