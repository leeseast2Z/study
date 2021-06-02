package com.leeseast2Z.singleton.multithreading;

/**
 * @author leeseast
 * @datetime 2021/6/1 19:07
 * 2. “急切”实例化
 */
public class SingletonClass3 {
    // JVM加载的时候创建对象，“急切”实例化
    private static SingletonClass3 singletonClass = new SingletonClass3();

    private SingletonClass3() {}

    public static SingletonClass3 getInstance() {
        if (singletonClass == null) {
            singletonClass = new SingletonClass3();
        }
        return singletonClass;
    }
}
