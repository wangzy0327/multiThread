package com.thread.others.unsafeSimpleDateFormat.formatOK02;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * 采用 ThreadLocal 为每个线程保存一个 SimpleDateFormat对象的变量
 */
public class MyThread extends Thread{
    private String dateString;
    public MyThread(SimpleDateFormat sdf,String dateString){
        super();
        this.dateString = dateString;
    }

    @Override
    public void run(){
        try {
            Date dateRef = DateTools.getSimpleDateFormat("yyyy-MM-dd").parse(dateString);
            String newDateString = DateTools.getSimpleDateFormat("yyyy-MM-dd").format(dateRef).toString();
            if(!newDateString.equals(dateString)){
                System.out.println("ThreadName = "+this.getName()
                                    +"报错了 日期字符串 ："+dateString+" 转换成的日期为："+newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
