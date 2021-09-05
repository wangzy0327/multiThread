# 对象及变量的并发访问

应着重掌握的技术点

- synchronized对象监视器为Object时的作用

- synchronized对象监视器为Class时的使用

- 非线程安全是如何出现的

- 关键字volatile的主要作用

- 关键字volatile与synchronized的区别及使用情况

  ### synchronized同步方法

  1. 方法内的变量为线程安全
  2. 实例变量非线程安全