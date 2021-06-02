package com.leeseast2Z.singleton;

import com.leeseast2Z.singleton.multithreading.SingletonClass4;

/**
 * @author leeseast
 * @datetime 2021/6/1 19:08
 * 在多线程的情况下，getInstance方法可能会返回两个不一样的对象，打破“只有一个对象”
 * 1. 把getInstance变成同步方法
 * 同步会降低性能，更严重的是只有第一次执行此方法时，才真正需要同步，之后的每次调用这个方法，同步都是一种累赘
 *
 * 2.使用“急切”创建实例，而不用延迟实例化的做法，依赖于JVM在加载这个类时马上创建此唯一的对象
 *
 * 3.Double Checked 双重检查加锁，在getInstance中减少使用同步
 */
public class SingletonMain {

    public static void main(String[] args) {
        SingletonClass4 obj1 = SingletonClass4.getInstance();
        SingletonClass4 obj2 = SingletonClass4.getInstance();
        if(obj1 != obj2) {
            System.out.println("omg !~");
        }
    }
}
