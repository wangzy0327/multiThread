package com.thread.coreAPI.stopThread.stop.throwLock;

/**
 * 使用stop()释放锁会给数据造成不一致性的结果。如果出现这样的情况，程序处理数据就有可能遭到破坏，最终导致程序执行的流程破坏，一定要特别注意。
 */
public class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printString(String username,String password){
        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
