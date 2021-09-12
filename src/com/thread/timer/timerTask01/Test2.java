package com.thread.timer.timerTask01;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * 当执行任务的时间早于当前时间
 * 立即执行
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("当前时间："+new Date());
        Calendar calendarRef = Calendar.getInstance();
        calendarRef.set(Calendar.SECOND,calendarRef.get(Calendar.SECOND) - 10);
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
     * 当前时间：Sun Sep 12 15:34:34 CST 2021
     * 任务执行了，时间为：Sun Sep 12 15:34:34 CST 2021
     *
     */
}
