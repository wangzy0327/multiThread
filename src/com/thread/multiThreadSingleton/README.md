## 单例模式与多线程

如何使单例模式遇到多线程是安全的、正确的

### 立即加载/"饿汉模式"

立即加载是使用类的时候已经将对象创建完毕，常见的实现办法就是直接new实例化。

[示例](hungryMode/MyObject.java)

### 延迟加载/"懒汉模式"

延迟加载就是在调用get()方法时实例才被创建。

[非安全示例](lazyMode/notSafe/MyObject.java)  [低效示例](lazyMode/safe/lowPerformance/MyObject.java)  [DCL示例](lazyMode/safe/DCL/MyObject.java)

### 使用静态内置类实现单例模式

[示例](staticInnerClass/MyObject.java)

### 序列化与反序列化的单例模式

[示例](seriallize/MyObject.java)

### 使用static代码块实现单例模式

[示例](staticCodeBlock/MyObject.java)

### 使用enum枚举数据类型实现单例模式

在使用枚举类时，构造方法会被自动调用，也可以应用其这个特性实现单例模式

[示例](enumSingleton/MyObject.java)

### 完善使用enum枚举类实现单例模式

示例

