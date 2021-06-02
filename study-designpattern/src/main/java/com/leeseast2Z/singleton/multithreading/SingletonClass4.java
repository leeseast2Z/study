package com.leeseast2Z.singleton.multithreading;

/**
 * @author leeseast
 * @datetime 2021/6/1 19:07
 *
 * 3. 减少同步方法
 */
public class SingletonClass4 {
    // volatile关键词确保：变量被初始化时，多个线程正确的处理变量
    private volatile static SingletonClass4 singletonClass;

    private SingletonClass4() {}

    /**
     * 双重加锁
     */
    public static SingletonClass4 getInstance() {
        if (singletonClass == null) {
            synchronized (SingletonClass4.class) {
                // 进入区块后，再检查一次
                if (singletonClass == null) {
                    singletonClass = new SingletonClass4();
                }
            }
        }
        return singletonClass;
    }
}
