## 拾遗增补

应该掌握如下知识点：

- 线程组的使用
- 如何切换线程状态
- SimpleDataFormat类与多线程的解决办法
- 如何处理线程的异常

### 线程的状态

线程对象在不同的状态时期有不同的状态，状态信息就存在于State枚举类中。

![线程状态](imgs/1.jpg)



方法与线程状态关系转换图

![方法与线程状态关系转换图](imgs/2.jpg)



NEW状态是线程实例化后还从未执行start()方法时的状态；而RUNNABLE状态是线程进入运行的状态；TERMINATED是线程被销毁时的状态；TIMED_WAITING代表线程执行了Thread.sleep()、wait(long)、join(long)方法，呈等待状态；BLOCKED代表某一个线程在等待锁的时候；WAITING代表线程执行了Object.wait()方法后所处的状态。

### 线程组

可以把线程归属到某一个线程组中，线程组中可以有线程对象，也可以有线程组，组中还可以有线程。

![线程组](imgs/3.jpg)

### 使线程具有有序性

### SimpleDateFormat非线程安全