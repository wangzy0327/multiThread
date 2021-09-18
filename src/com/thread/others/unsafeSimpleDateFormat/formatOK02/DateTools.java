package com.thread.others.unsafeSimpleDateFormat.formatOK02;

import java.text.SimpleDateFormat;

public class DateTools {
    private static ThreadLocal<SimpleDateFormat> tl
            = new ThreadLocal<>();
    public static SimpleDateFormat getSimpleDateFormat(String datePattern){
        SimpleDateFormat sdf = null;
        sdf = tl.get();
        if(sdf == null){
            sdf = new SimpleDateFormat(datePattern);
            tl.set(sdf);
        }
        return sdf;
    }
}
