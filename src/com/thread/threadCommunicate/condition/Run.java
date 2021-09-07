package com.thread.threadCommunicate.condition;

import com.thread.threadCommunicate.condition.entity.Add;
import com.thread.threadCommunicate.condition.entity.Subtract;


/**
 * 出现这样异常的原因是因为 有两个实现删除remove()操作的线程。
 * 第一个实现减操作的线程能够正确删除list中索引为0的元素，但第二个实现的减操作线程则出现索引溢出的异常，因为list中仅仅添加了一个数据
 *
 * 这也说明了，wait被唤醒后是继续wait后面的代码执行，而不是重新从monitor同步代码块处执行。
 *
 * 解决办法，用while 代替 if
 *
 * 使用while能在wait重新被唤醒时再次判断临界条件是否能满足，而用if的话，则唤醒之后就会继续往下执行，也就是说只会判断一次临界条件
 *
 *
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);
        ThreadSubtract subtract1Thread = new ThreadSubtract(subtract);
        subtract1Thread.setName("subtract1Thread");
        subtract1Thread.start();
        ThreadSubtract subtract2Thread = new ThreadSubtract(subtract);
        subtract2Thread.start();
        Thread.sleep(1000);
        ThreadAdd addThread = new ThreadAdd(add);
        addThread.setName("addThread");
        addThread.start();
    }


    /**
     * 使用while处理
     *
     * wait begin ThreadName = subtract1Thread
     * wait begin ThreadName = Thread-1
     * wait end ThreadName = Thread-1
     * list size = 0
     * wait end ThreadName = subtract1Thread
     * wait begin ThreadName = subtract1Thread
     *
     */


    /**
     * 使用if处理，索引越界
     *
     * wait begin ThreadName = subtract1Thread
     * wait begin ThreadName = Thread-1
     * wait end ThreadName = Thread-1
     * list size = 0
     * wait end ThreadName = subtract1Thread
     * Exception in thread "subtract1Thread" java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
     *
     */
}
