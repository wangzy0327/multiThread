package com.thread.timer.timerTaskPeriod01;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 以当前时间为参考时间，在此基础上延迟指定的毫秒数执行一次TimerTask任务，再以某一个间隔无限次数执行某一任务。
 */
public class Run {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行了！时间为："+new Date());
            }
        };
        Timer timer = new Timer();
        System.out.println("当前时间："+new Date());
        timer.schedule(task,3000,5000);
    }
    /**
     *
     * 当前时间：Sun Sep 12 15:49:33 CST 2021
     * 运行了！时间为：Sun Sep 12 15:49:36 CST 2021
     * 运行了！时间为：Sun Sep 12 15:49:41 CST 2021
     * 运行了！时间为：Sun Sep 12 15:49:46 CST 2021
     * 运行了！时间为：Sun Sep 12 15:49:51 CST 2021
     * 运行了！时间为：Sun Sep 12 15:49:56 CST 2021
     *   ...
     *
     */
}
