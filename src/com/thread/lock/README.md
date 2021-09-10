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

锁Lock分为“公平锁”和“非公平锁”，公平锁表示线程获取锁的顺序是按照线程加锁的顺序（加锁线程的可运行状态创建顺序）来分配的，即先来先得的FIFO先进先出顺序。而非公平锁就是一种获取锁的抢占机制，是随机获得锁的，和公平锁不一样的就是先来的不一定先得到锁，这个方式可能造成某些线程一直拿不到锁，结果也就是不公平的了。示例

#### Lock常用方法

**方法getHoldCount()、getQueueLength()、getWaitQueueLength()**

方法int getHoldCount()的作用是查询当前线程保持此锁定的个数，也就是调用lock()方法的次数。

方法int getQueueLength()的作用是返回正等待获取此锁定的线程数。比如有5个线程都获取同一把锁，1个线程首先执行await()方法，那么在调用getQueueLength()方法后返回值是4，说明有4个线程同时在等待lock的释放。

方法 int getWaitQueueLength(Condition condition) 的作用是 返回等待与此锁定相关的给定条件Condition的线程数，比如有5个线程，每个线程都执行了同一个condition对象的await()方法，则调用getWaitQueueLength(Condition condition)方法时返回的int值是5.

**方法hasQueuedThread()、hasQueueThreads()、hasWaiters()**

方法boolean hasQueuedThread(Thread thread)的作用是查询指定的线程是否正在等待获取此锁定。

方法boolean hasQueuedThreads()的作用是查询是否有线程正在等待获取此锁定。

方法boolean hasWaiters(Condition condition)的作用是查询是否有线程正在等待与此锁定有关的condition条件。

**方法isFair()、isHeldByCurrentThread()、isLocked()**

方法boolean isFair()的作用是判断是不是公平锁。

方法boolean isHeldByCurrentThread()的作用是查询当前线程是否保持此锁定。

方法boolean isLocked()的作用是查询此锁定是否由任意线程保持。

**方法lockInterruptibly()、tryLock()、tryLock(long timeout,TimeUnit unit)**

方法void lockInterruptibly()的作用是：如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常。

方法boolean tryLock()的作用是：仅在调用时锁定未被另一个线程保持的情况下，才获取该锁定。

方法boolean tryLock(long timeout,TimeUnit unit)的作用是，如果锁定在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁定。

**方法awaitUninterruptibly()、awaitUntil(Calendar calendar)**

方法awaitUninterruptibly()的作用是：在await时，遇到中断异常继续正常运行

方法awaitUntil(Calendar calendar)的作用是：在指定时间到达后自动唤醒自己，也可在等待时间到达前被其他线程提前唤醒。

**使用Condition实现顺序执行**

示例

#### ReentrantReadWriteLock类

类ReentrantLock具有完全互斥排他的效果，即同一时间只有一个线程在执行ReentrantLock.lock()方法后面的任务。读写锁ReentrantReadWriteLock类，使用可以加快效率，在某些不需要操作实例变量的方法中，可以采用来提升代码运行速度。

读写锁也有两个锁，一个是读操作相关的锁，也成共享锁；另一个是写操作相关的锁，也叫排他锁。多个读锁不互斥，读写互斥，写写互斥。