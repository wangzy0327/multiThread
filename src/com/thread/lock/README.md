## Lock的使用

java5中Lock对象也能实现同步的效果，而且在使用上更加方便。应着重掌握如下2个知识点：

- ReentrantLock类的使用
- ReentrantReadWriteLock类的使用

### 使用ReentrantLock类

JDK1.5新增加了ReentrantLock类也能达到synchronized关键字线程之间同步互斥的效果，而且在扩展功能上也更加强大，比如具有嗅探锁定、多路分支通知等功能，而且在使用上也比synchronized更加的灵活。

ReentrantLock实现同步 [示例1](reentrantLockSync/Run.java) [示例2](reentrantLockSync/Run2.java)

#### 使用Condition实现等待/通知

关键字synchronized与wait()和notify/notifyAll()方法相结合可以实现等待/通知模式，类ReentrantLock也可以实现同样的功能，但需要借助于Condition对象。Condition类是在JDK5中出现的技术，使用它有更好的灵活性，比如可以实现**多路通知**功能，也就是在一个Lock对象连可以创建**多个Condition(即对象监视器)**示例，线程对象可以注册在指定的Condition中，从而可以有选择性地进行线程通知，在调度线程上更加灵活。

在使用notify()/notifyAll()方法进行通知时，被通知的线程却是由JVM随机选择的。但是使用ReentrantLock结合Condition类是可以实现前面介绍过得“**选择性通知**”，这个功能是非常重要的，而且在Condition类中是默认提供的。

而synchronized就相当于整个Lock对象中只有一个单一的Condition对象，所有的线程都注册在它一个对象的身上。线程开始**notifyAll()**时，需要通知所有的WAITING线程，没有选择权，会出现相当大的**效率问题**。[示例](condition/Run.java)

```
Object类中的wait()方法 相当于 Condition类中的await()方法
Object类中的wait(long timeout)方法相当于Condition类中的await(long time,TimeUnit unit)方法
Object类中的notify()方法相当于Condition类中的signal()方法
Object类中的notifyAll()方法相当于Condition类中的signalAll()方法
```

#### 生产者/消费者模式：一对一交替打印

[示例](signalProdConsum/Run.java)

#### 生产者/消费者模式：多对多交替打印

[示例](multiProdConsum/Run.java)

#### 生产者/消费者模式：多对多交替打印 唤醒指定组

[示例](multiProdConsumSpec/Run.java)  注：唤醒指定组与唤醒所有线程的差别

#### 公平锁与非公平锁

锁Lock分为“公平锁”和“非公平锁”，公平锁表示线程获取锁的顺序是按照线程加锁的顺序（加锁线程的可运行状态创建顺序）来分配的，即先来先得的FIFO先进先出顺序。而非公平锁就是一种获取锁的抢占机制，是随机获得锁的，和公平锁不一样的就是先来的不一定先得到锁，这个方式可能造成某些线程一直拿不到锁，结果也就是不公平的了。