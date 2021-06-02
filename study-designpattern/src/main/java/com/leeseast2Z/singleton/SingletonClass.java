package com.leeseast2Z.singleton;

/**
 * @author leeseast
 * @datetime 2021/6/1 19:07
 *
 * 单件模式确保：程序中一个类最多只有一个实例，也能提供访问这个实例的全局点
 * 如何实现：一个私有构造器、一个静态变量、一个静态方法
 *
 * 注意：如果使用多个类加载器，可能导致单例模式失效而产生多个实例
 *
 * 对比全局变量：全局变量可以提供全局访问，但是不能保证只有一个实例
 * 在ClassA中
 * static A a = new A
 *
 * 在ClassB中
 * static A a = new A
 */
public class SingletonClass {

    private static SingletonClass singletonClass;

    private SingletonClass() {

    }

    /**
     * 延迟实例化
     * 多线程情况下会存在多个对象
     * @author lee
     * @datetime 2021-06-01 19:31:51  
     * @return com.leeseast2Z.singleton.SingletonClass
     */
    public static SingletonClass getInstance() {
        if (singletonClass == null) {
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }
}
