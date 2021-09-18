package com.thread.others.unsafeSimpleDateFormat.formatOK01;


/**
 * 解决SimpleDateFormat 异常 方案一：每个Thread 创建一个 SimpleDateFormat来处理日期转换
 *
 */
public class Test {
    public static void main(String[] args) {
        String[] dateStringArray = new String[]{
                "2000-01-01","2000-01-02","2000-01-03","2000-01-04","2000-01-05",
                "2000-01-10","2000-01-09","2000-01-08","2000-01-07","2000-01-06"
        };
        MyThread[] threadArray = new MyThread[10];
        for(int i = 0;i < 10;i++){
            threadArray[i] = new MyThread(dateStringArray[i]);
        }
        for(int i = 0;i < 10;i++){
            threadArray[i].start();
        }
    }

    /**
     *
     * 不报错
     Process finished with exit code 0
     *
     */
}
