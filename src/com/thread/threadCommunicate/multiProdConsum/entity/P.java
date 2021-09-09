package com.thread.threadCommunicate.multiProdConsum.entity;

//生产者
public class P {
    private String lock;
    public P(String lock){
        super();
        this.lock = lock;
    }
    public void setValue(){
        try {
            synchronized (lock){
                //如果 valueObject容器里 不为空，则释放 通知 锁 wait
//                if(!ValueObject.value.equals("")){
                while(!ValueObject.value.equals("")){
                    System.out.println("生产者 "+Thread.currentThread().getName()+" WAITING了★");
                    lock.wait();
                }
                System.out.println("生产者 "+Thread.currentThread().getName()+" RUNNABLE了★");
                String value = System.currentTimeMillis()+"_"
                        +System.nanoTime();
                ValueObject.value = value;
                //添加元素后，通知  等待的 消费者 线程
//                lock.notify();
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
