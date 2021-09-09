## 线程间通信

需要着重掌握的技术点

- 使用wait/notify实现线程间的通信
- 生产者/消费者模式的实现
- 方法join的使用
- ThreadLocal类的使用

### 等待/通知机制

#### wait/nofify使用

wait()、notify()、notifyAll()都是Object类的方法.

wait()方法可以使调用该方法的线程释放共享资源的锁，然后从运行状态退出，进入等待队列，直到被再次唤醒。

notify()方法可以随机唤醒等待队列中等待同一共享资源的”一个“线程，并使该线程退出等待队列，进入可运行状态，也就是notify()方法仅通知”一个“线程”。

notifyAll()方法可以使所有正在等待队列中等待同一共享资源的“全部”线程从等待状态退出，进入可运行状态。此时，优先级最高的那个线程最先执行，但也有可能是随机执行，因为这要取决于JVM虚拟机的实现。

线程对象状态切换如下图所示。

![线程对象状态切换图](imgs\1.jpg)

<center>线程状态切换示意图</center>

1）新创建一个新的线程对象后，再调用它的start()方法，系统会为此线程分配CPU资源，使其处于Runnable（可运行）状态，这是一个准备运行的阶段。如果线程抢占CPU资源，此线程就处于Running（运行）状态。

2）Runnable状态和Running状态可相互切换，因为有可能线程运行一段时间后，有其他高优先级的线程抢占了CPU资源，这时此线程就从Running状态变成Runnable状态。

线程进入Runnable状态大体分为如下5种情况：

- 调用sleep()方法后经过的时间超过了指定的休眠时间。
- 线程调用的阻塞IO已经返回，阻塞方法执行完毕。
- 线程成功地获得了试图同步的监视器。
- 线程正在等待某个通知，其他线程发出了通知。
- 处于挂起状态的线程调用了resume恢复方法。

3）Blocked是阻塞的意思，例如遇到了一个IO操作，此时CPU处于空闲状态，可能会转而把CPU时间片分配给其他线程，这时也可以称为“暂停”状态。Blocked状态结束后，进入Runnable状态，等待系统重新分配资源。

出现阻塞的情况大体分为如下5种：

- 线程调用sleep方法，主动放弃占用的处理器资源。
- 线程调用了阻塞式IO方法，在该方法返回前，该线程被阻塞。
- 线程试图获得一个同步监视器，但该同步监视器正在被其他线程所持有。
- 线程等待某个通知。
- 程序调用了suspend方法将该线程挂起。此方法容易导致死锁，尽量避免使用该方法。

4）run()方法运行结束后进入销毁阶段，整个线程执行完毕。

每个锁对象都有两个队列，一个是就绪队列，一个是阻塞队列。就绪队列存储了将要获得锁的线程，阻塞队列存储了被阻塞的线程。一个线程被唤醒后，才会进入就绪队列，等待CPU的调度；反之，一个线程被wait后，就会进入阻塞队列，等待下一次被唤醒。



wait/notify 调用后，锁的释放情况：

- 当wait()方法被执行后，锁被自动释放
- 执行完notify()，notifyAll()方法，锁却不自动释放，直到当前线程执行结束才释放锁。[示例](waitNotify/Test.java)

等待通知 wait/notify 使用总结：

- 使用wait时切忌要使用在while循环内 [示例](condition/Run.java)

- wait被唤醒后，会继续往wait之后的代码执行，而不是重新从monitor同步块处执行

注：wait()立即释放锁，notify()，notifyAll()线程执行结束才释放锁，sleep()不释放锁。[示例](waitNotify/Test.java)



#### 当interrupt方法遇到wait方法

当线程呈wait()状态时，调用线程对象的interrupt()方法会出现InterruptedException异常。

总结：

- 执行完同步代码块就会释放对象的锁
- 在执行同步代码块的过程中，遇到异常而导致线程终止，锁也会被释放。
- 在执行同步代码块的过程中，执行了锁所属对象的wait()方法，这个线程会释放对象锁，而此线程对象会进入线程等待池中，等待被唤醒。

#### notify()只随机唤起一个线程，notifyAll()唤醒所有线程

方法wait(long)的使用

带一个参数的wait(long)方法的功能是等待某一个

#### 等待wait条件的变化

在使用wait/notify模式时，还需要注意，也就是wait等待的条件发生了变化时，容易造成程序逻辑混乱。

结论总结：

1）使用wait时切忌要使用在while循环内。

2）wait被唤醒后，会继续往wait之后的代码执行，而不是重新从monitor同步块处执行。[示例](condition/Run.java)

注：使用while能在wait重新被唤醒时再次判断临界条件是否能满足，而用if的话，则唤醒之后就会继续往下执行，也就是说只会判断一次。

#### 生产者/消费者模式

一生产与一消费 [操作值](prodConsum/Run.java)  [操作栈](prodConsumStack/Run.java)

多生产与多消费 [操作值](multiProdConsum/Run.java)，[操作栈](multiProdConsumStack/Run.java) 解决wait条件改变与假死

#### 通过管道进行线程间通信

字节流 PipedInputStream和PipedOutputStream

字符流 PipedReader和PipedWriter

等待/通知交叉备份 [示例](crossBackup/Run.java)

### join使用

方法join的作用是使所属的线程对象x正常执行run()方法中的任务，而使当前线程z进行无限期的阻塞，等待线程x销毁后再继续执行线程z后面的代码。

join具有使线程排队运行的作用，有些类似同步的运行效果。join与synchronized的区别是：

join在**内部使用wait()方法**进行等待，而synchronized关键字使用的是“对象监视器”原理作为同步。

#### 方法join与异常

#### 在join的过程中，如果当前线程对象被中断，则当前线程出现异常。

ep：在B线程中调用A线程的join方法，然后中断B线程，B线程异常，A.join()的线程并未出现异常还继续运行。

方法join(long)的使用

方法join(long)与sleep(long)的区别

方法join(long)的功能在内部是使用wait(long)方法来实现的，所以join(long)方法具有**释放锁**的特点。

### 类ThreadLocal的使用

类ThreadLocal主要解决的就是每个线程绑定自己的值，将ThreadLocal类作为可以存储每个线程的私有数据。[示例](threadLocal/isolate/Run.java)

#### 线程变量的隔离性

### 类InheritableThreadLocal的使用

使用类InheritableThreadLocal可以在子线程中取得父线程继承下来的值。

#### 值继承

#### 值继承再修改



表 Object常用方法摘要

| 返回变量和类型     | 方法                            | 描述                                                         |
| ------------------ | ------------------------------- | ------------------------------------------------------------ |
| `protected Object` | `clone()`                       | Creates and returns a copy of this object.                   |
| `boolean`          | `equals(Object obj)`            | Indicates whether some other object is "equal to" this one.  |
| `protected void`   | `finalize()`                    | **Deprecated.**The finalization mechanism is inherently problematic. |
| `Class<?>`         | `getClass()`                    | Returns the runtime class of this `Object`.                  |
| `int`              | `hashCode()`                    | Returns a hash code value for the object.                    |
| `void`             | `notify()`                      | Wakes up a single thread that is waiting on this object's monitor. |
| `void`             | `notifyAll()`                   | Wakes up all threads that are waiting on this object's monitor. |
| `String`           | `toString()`                    | Returns a string representation of the object.               |
| `void`             | `wait()`                        | Causes the current thread to wait until it is awakened, typically by being *notified* or *interrupted*. |
| `void`             | `wait(long timeout)`            | Causes the current thread to wait until it is awakened, typically by being *notified* or *interrupted*, or until a certain amount of real time has elapsed. |
| `void`             | `wait(long timeout, int nanos)` | Causes the current thread to wait until it is awakened, typically by being *notified* or *interrupted*, or until a certain amount of real time has elapsed. |

