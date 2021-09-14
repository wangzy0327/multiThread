package com.thread.multiThreadSingleton.seriallize;

import java.io.Serializable;

/**
 * 静态内部类可以达到线程安全问题
 * 但如果遇到序列化对象时，使用默认的方式运行得到的结果还是多例的
 *
 * 解决办法 是 在反序列化中使用 readResolve
 *
 */
public class MyObject implements Serializable {
    private static final long serialVersionUID = 888L;

    //内部类方式
    private static class MyObjectHandler{
        public static final MyObject myObject = new MyObject();
    }

    private MyObject(){}

    public static MyObject getInstance(){
        return MyObjectHandler.myObject;
    }


    /**
     *
     * //返回的obj对象，就是ObjectInputStream的readObject0返回的对象。
     *   Object obj = readObject0(false);
     *
     * case TC_ENUM:
     * // 这句代码是针对枚举，单例中为啥枚举式最安全，就是看这行代码，后续，小伙伴可以研读研读
     *                     return checkResolve(readEnum(unshared));
     *
     *  case TC_OBJECT:
     *  //我们的Object 类
     *                     return checkResolve(readOrdinaryObject(unshared));
     *
     * checkResolve：检查对象，并替换 readOrdinaryObject：读取二进制对象 我们先进入readOrdinaryObject（）方法
     *
     *  try {
     *             obj = desc.isInstantiable() ? desc.newInstance() : null;
     *         } catch (Exception ex) {
     *             throw (IOException) new InvalidClassException(
     *                 desc.forClass().getName(),
     *                 "unable to create instance").initCause(ex);
     *         }
     *
     * 可以看到，readOrdinaryObject（）方法是通过desc.isInstantiable() 来判断是否需要new一个对象，
     * 如果返回true，方法通过反射的方式调用无参构造方法新建一个对象，否则，返回空。
     * 那我们进入isInstantiable()方法
     *
     *
     *  boolean isInstantiable() {
     *         requireInitialized();
     *         //cons是构造函数
     *         return (cons != null);
     *     }
     *
     *
     * cons != null是判断类的构造方法是否为空，我们大家应该知道，Class类的构造方法肯定不为空,
     * 显然isInstantiable（）返回true，也就是说，一定会new 一个对象，且被obj接收。
     * 我们回到readOrdinaryObject（）方法,查看初始化完成后的操作。
     *
     *
     * if (obj != null &&
     *             handles.lookupException(passHandle) == null &&
     *             desc.hasReadResolveMethod())
     *         {
     *         	// ！敲重点，这句代码块是为什么会执行我们在单例中定义的readResolve()方法的核心。
     *
     *             Object rep = desc.invokeReadResolve(obj);
     *             if (unshared && rep.getClass().isArray()) {
     *                 rep = cloneArray(rep);
     *             }
     *             if (rep != obj) {
     *                 // Filter the replacement object
     *                 if (rep != null) {
     *                     if (rep.getClass().isArray()) {
     *                         filterCheck(rep.getClass(), Array.getLength(rep));
     *                     } else {
     *                         filterCheck(rep.getClass(), -1);
     *                     }
     *                 }
     *                 handles.setObject(passHandle, obj = rep);
     *             }
     *         }
     *
     * 我们要敲黑板了，这里就是单例类中定义readResolve就可以解决问题的关键所在！
     * 若"obj != null &&handles.lookupException(passHandle) == null &&desc.hasReadResolveMethod()"这条语句返回true
     * 就会调用Object rep = desc.invokeReadResolve(obj) 这条语句。
     * 我们进入hasReadResolveMethod（）方法
     *
     * boolean hasReadResolveMethod() {
     *         requireInitialized();
     *         return (readResolveMethod != null);
     *     }
     *
     *"readResolveMethod != null "的判断，我们深究进去，readResolveMethod是从哪里读取进来的
     *
     *
     * // 定义readResolveMethod 的方法
     * private Method readResolveMethod;
     * // 对readResolveMethod赋值， 通过反射获得类中名为readResolve的方法
     *  readResolveMethod = getInheritableMethod(
     *                         cl, "readResolve", null, Object.class);
     *
     * 也就是说！
     * 若目标类有readResolve方法，那就通过反射的方式调用要被反序列化的类中的readResolve方法，返回一个对象，
     * 然后把这个新的对象复制给之前创建的obj（即最终返回的对象）。那被反序列化的类中的readResolve 方法里是什么？就是直接返回我们的单例对象。
     * 再次贴上来，我们的单例类。
     *
     *
     *
     *
     */

    /**
     * 解决办法 是 在反序列化中使用 readResolve
     * @return
     */
    protected Object readResolve(){
        System.out.println("调用了readResolve方法");
        return MyObjectHandler.myObject;
    }

}
