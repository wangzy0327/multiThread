package com.thread.others.unsafeSimpleDateFormat.formatError;

import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = new String[]{
                "2000-01-01","2000-01-02","2000-01-03","2000-01-04","2000-01-05",
                "2000-01-10","2000-01-09","2000-01-08","2000-01-07","2000-01-06"
        };
        MyThread[] threadArray = new MyThread[10];
        for(int i = 0;i < 10;i++){
            threadArray[i] = new MyThread(sdf,dateStringArray[i]);
        }
        for(int i = 0;i < 10;i++){
            threadArray[i].start();
        }
    }

    /**
     * 	at java.text.DecimalFormat.parse(DecimalFormat.java:2082)
     * 	at java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1869)
     * 	at java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1514)
     * 	at java.text.DateFormat.parse(DateFormat.java:364)
     * 	at com.thread.others.unsafeSimpleDateFormat.formatError.MyThread.run(MyThread.java:19)
     * ThreadName = Thread-0报错了 日期字符串 ：2000-01-01 转换成的日期为：1970-01-08
     * ThreadName = Thread-7报错了 日期字符串 ：2000-01-08 转换成的日期为：1970-01-08
     * ThreadName = Thread-4报错了 日期字符串 ：2000-01-05 转换成的日期为：1970-01-08
     * ThreadName = Thread-1报错了 日期字符串 ：2000-01-02 转换成的日期为：0000-01-06
     * ThreadName = Thread-3报错了 日期字符串 ：2000-01-04 转换成的日期为：94642378-01-06
     * ThreadName = Thread-8报错了 日期字符串 ：2000-01-07 转换成的日期为：9464-01-07
     *
     */
}
