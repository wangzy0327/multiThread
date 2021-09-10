package com.thread.lock.multiProdConsum;



/**
 * 生产者/消费者  多对多交替打印
 *
 * 对比 “一对一” 打印，这里采用signalAll()来解决 ：“假死”问题
 *
 * 由于程序中使用了一个Condition对象，所以唤醒的是所有线程，所以会出现
 *
 *
 * 在 所有线程都经历了 “有可能 。。。 start” 后，singalAll()每次调用后面既会出现 对方组线程的end 也会出现 己方线程的end （因为己方和对方都会被唤醒）
 *
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA[] threadA = new MyThreadA[2];
        MyThreadB[] threadB = new MyThreadB[2];
        for(int i = 0;i < 2;i++){
            threadA[i] = new MyThreadA(myService);
            threadA[i].setName("生产者 "+(i+1));
            threadB[i] = new MyThreadB(myService);
            threadB[i].setName("消费者 "+(i+1));
            threadA[i].start();
            threadB[i].start();
        }



//        Thread.sleep(3000);



//        while(true){
//        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
//        System.out.println("线程组数： "+Thread.currentThread().getThreadGroup().activeGroupCount());
//        System.out.println("线程数组个数："+threadArray.length);
//        Thread.currentThread().getThreadGroup().enumerate(threadArray);
//        for(int i = 0;i < threadArray.length;i++){
//            System.out.println(threadArray[i].getName()+" "
//                                + threadArray[i].getState());
//        }
//        }

    }

    /**
     *
     生产者 1  set 打印★
     消费者 1  get 打印☆
     消费者 1  有可能 get ☆☆连续 start
     生产者 1  set 打印★
     生产者 1  有可能 set ★★连续 start
     生产者 2  有可能 set ★★连续 start
     消费者 2  get 打印☆
     消费者 2  有可能 get ☆☆连续 start
     消费者 1  有可能 get ☆☆连续 end
     消费者 1  有可能 get ☆☆连续 start
     生产者 1  有可能 set ★★连续 end
     ---------------------从这里开始所有线程都处于 获取锁 待激活状态-------------------------------
     生产者 1  set 打印★
     生产者 1  有可能 set ★★连续 start
     生产者 2  有可能 set ★★连续 end
     生产者 2  有可能 set ★★连续 start
     消费者 2  有可能 get ☆☆连续 end
     消费者 2  get 打印☆
     消费者 2  有可能 get ☆☆连续 start
     消费者 1  有可能 get ☆☆连续 end
     消费者 1  有可能 get ☆☆连续 start
     生产者 1  有可能 set ★★连续 end
     *
     */


}
