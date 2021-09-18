package com.thread.others.unsafeSimpleDateFormat.formatOK02;

import com.thread.others.unsafeSimpleDateFormat.formatOK01.MyThread;


/**
 *
 * 采用ThreadLocal类使线程绑定到指定的对象。使用该类也可以 解决多线程环境下SimpleDateFormat类处理错误的情况
 */
public class Test {
    public static void main(String[] args) {
        String[] dateStringArray = new String[]{
                "2000-01-01","2000-01-02","2000-01-03","2000-01-04","2000-01-05",
                "2000-01-10","2000-01-09","2000-01-08","2000-01-07","2000-01-06"
        };
        com.thread.others.unsafeSimpleDateFormat.formatOK01.MyThread[] threadArray = new com.thread.others.unsafeSimpleDateFormat.formatOK01.MyThread[10];
        for(int i = 0;i < 10;i++){
            threadArray[i] = new MyThread(dateStringArray[i]);
        }
        for(int i = 0;i < 10;i++){
            threadArray[i].start();
        }
    }

    /**
     *
     Process finished with exit code 0
     *
     */
}
