package com.thread.timer.timerTask01;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * 创建一个Timer就是启动一个新的线程，这个新启动的线程并不是守护线程，一直在运行，所以进程不结束
 *
 * 如果将Timer设置为 守护线程，则进程退出，并且在TimerTask中的任务不被执行。
 *
 */

/**
 * 当执行任务的时间晚于当前时间
 * 未来执行
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("当前时间："+new Date());
        Calendar calendarRef = Calendar.getInstance();
        calendarRef.add(Calendar.SECOND,10);
        Date runDate = calendarRef.getTime();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务执行了，时间为："+new Date());
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,runDate);

    }

    /**
     *
     * 当前时间：Sun Sep 12 15:31:37 CST 2021
     * 任务执行了，时间为：Sun Sep 12 15:31:47 CST 2021
     *
     */
}
