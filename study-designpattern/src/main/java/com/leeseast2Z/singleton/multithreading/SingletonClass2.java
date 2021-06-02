package com.leeseast2Z.singleton.multithreading;

/**
 * @author leeseast
 * @datetime 2021/6/1 19:07
 *
 * 1. 使用同步方法
 */
public class SingletonClass2 {

    private static SingletonClass2 singletonClass;

    private SingletonClass2() {}

    /**
     * 延迟实例化
     * 添加同步方法，会降低性能
     */
    public synchronized static SingletonClass2 getInstance() {
        if (singletonClass == null) {
            singletonClass = new SingletonClass2();
        }
        return singletonClass;
    }
}
