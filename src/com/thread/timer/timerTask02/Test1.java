package com.thread.timer.timerTask02;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer中允许有多个TimerTask任务及延时测试
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("当前时间："+new Date());
        Calendar calendarRef1 = Calendar.getInstance();
        calendarRef1.add(Calendar.SECOND,10);
        Date runDate1 = calendarRef1.getTime();
        System.out.println("计划时间为："+runDate1);

        Calendar calendarRef2 = Calendar.getInstance();
        calendarRef2.add(Calendar.SECOND,15);
        Date runDate2 = calendarRef2.getTime();
        System.out.println("计划时间为："+runDate2);

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("任务执行了，时间为："+new Date());
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务执行了，时间为："+new Date());
            }
        };

        Timer timer = new Timer();
        timer.schedule(task1,runDate1);
        timer.schedule(task2,runDate2);
    }

    /**
     * 多个TimerTask 未延迟执行
     *
     * 当前时间：Sun Sep 12 15:38:51 CST 2021
     * 计划时间为：Sun Sep 12 15:39:01 CST 2021
     * 计划时间为：Sun Sep 12 15:39:06 CST 2021
     * 任务执行了，时间为：Sun Sep 12 15:39:01 CST 2021
     * 任务执行了，时间为：Sun Sep 12 15:39:06 CST 2021
     *
     *
     */


    /**
     * 存在任务延迟执行，下一个任务不会按照原时间执行，会延时
     *
     * 当前时间：Sun Sep 12 15:40:57 CST 2021
     * 计划时间为：Sun Sep 12 15:41:07 CST 2021
     * 计划时间为：Sun Sep 12 15:41:12 CST 2021
     * 任务执行了，时间为：Sun Sep 12 15:41:07 CST 2021
     * 任务执行了，时间为：Sun Sep 12 15:41:27 CST 2021
     *
     *
     *
     */
}
