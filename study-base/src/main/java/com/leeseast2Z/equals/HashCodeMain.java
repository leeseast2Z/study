package com.leeseast2Z.equals;

import java.util.HashMap;

/**
 * @Author: limf
 * @Date: 2021/5/28 09:46
 * @Description: hashCode
 *
 * 对于集合类Set，Set是无序且不重复的，如何保证不重复？
 * 如果使用equals方法逐一比较，数据量大效率可想而知
 * 使用hashCode降低为了减少调用 equals() 方法的次数
 *
 * 1 << 2 = 2的n次幂
 */
public class HashCodeMain {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", "lee");
        hashMap.get("name");
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println(1 << 2);
        System.out.println("Integer.toHexString(123) = " + Integer.toBinaryString(32));
       /* // 1. 静态初始化
        int[] staticArray = new int[]{};
        int[] staticArray2 = {};// 简单写法
        // 静态初始化简单写法分开（不允许这样）
        int[] staticArray3;
        // staticArray3 = {1,2,3}; // Array initializer is not allowed here

        // 2. 动态初始化
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;*/
    }
}
