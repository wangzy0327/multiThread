package com.thread.threadCommunicate.prodConsum.entity;

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
                while(!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = "prod_"+System.currentTimeMillis()+"_"
                        +System.nanoTime();
                System.out.println("set的值是 "+value);
                ValueObject.value = value;
                //添加元素后，通知  等待的 消费者 线程
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
