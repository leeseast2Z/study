package com.leeseast2Z.equals;

/**
 * @Author: limf
 * @Date: 2021/5/28 09:15
 * @Description: equals
 * 基本数据类型：整型（字节型byte、短整型short、整型int、长整型long）、浮点型（单精度float、双精度double）、字符型char、布尔型boolean
 * String不是基本数据类型，属于引用数据类型
 *
 * ==和equals的区别
 * ==对于基本数据类型：比较值，对于引用数据类型比较内存地址
 *
 * equals比较值是否相同
 * 自反性：x.equals(x) == true
 * 对称性：当x.equals(y) == true时，y.equals(x) == true
 * 传递性
 * 一致性
 * 非空性：x.equals(null)==false
 *
 */
public class EqualsMain {

    public static void main(String[] args) {
        String str = "abc";
        String str2 = "abc";
        System.out.println("str.hashCode() = " + str.hashCode());
        System.out.println("str2.hashCode() = " + str2.hashCode());
        boolean equals = str.equals(str2);
        System.out.println("equals = " + equals);
        Integer integer = 1;
        Integer integer1 = 1;
        boolean equals1 = integer.equals(integer1);
        System.out.println("equals1 = " + equals1);
    }
}
