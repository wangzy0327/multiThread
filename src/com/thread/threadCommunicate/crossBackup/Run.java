package com.thread.threadCommunicate.crossBackup;


/**
 * 交替打印的原理就是使用如下作为标记
 * volatile private boolean prevIsA = false;
 *
 */
public class Run {
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for(int i = 0;i < 20;i++){
            BackupA a = new BackupA(dbTools);
            BackupB b = new BackupB(dbTools);
            a.start();
            b.start();
        }
    }

    /**
     *
     * ★★★★★
     * ★★★★★
     * ★★★★★
     * ★★★★★
     * ★★★★★
     * ☆☆☆☆☆
     * ☆☆☆☆☆
     * ☆☆☆☆☆
     * ☆☆☆☆☆
     * ☆☆☆☆☆
     * ★★★★★
     * ★★★★★
     * ★★★★★
     * ★★★★★
     * ★★★★★
     * ☆☆☆☆☆
     * ☆☆☆☆☆
     * ☆☆☆☆☆
     * ☆☆☆☆☆
     * ...
     *
     */
}
