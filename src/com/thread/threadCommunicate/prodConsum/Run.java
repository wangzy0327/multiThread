package com.thread.threadCommunicate.prodConsum;

import com.thread.threadCommunicate.prodConsum.entity.C;
import com.thread.threadCommunicate.prodConsum.entity.P;

/**
 * 本示例是 1个生产者和一个消费者进行数据的交互，在控制台中打印的日志是get和set交替运行的
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP pThread = new ThreadP(p);
        ThreadC rThread = new ThreadC(c);
        pThread.start();
        rThread.start();
    }

    /**
     *
     * set的值是 prod_1630995918008_1296175480133400
     * get的值是 prod_1630995918008_1296175480133400
     * set的值是 prod_1630995918008_1296175480154600
     * get的值是 prod_1630995918008_1296175480154600
     * set的值是 prod_1630995918008_1296175480175100
     * get的值是 prod_1630995918008_1296175480175100
     * set的值是 prod_1630995918008_1296175480200000
     * get的值是 prod_1630995918008_1296175480200000
     * set的值是 prod_1630995918008_1296175480219000
     * get的值是 prod_1630995918008_1296175480219000
     *
     */
}
