package com.test.exception;

import java.util.ArrayList;

/**
 * @Author: limf
 * @Date: 2021/5/27 14:59
 * @Description:
 */
public class Main2 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("123");
        arrayList.add(1);
        String str = (String) arrayList.get(0);
        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        String str1 = (String) arrayList.get(1);
    }

    public static void test2() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("123");
        arrayList.add("123");
        String s = arrayList.get(0);
    }

    public static void test3() {
        ArrayList<Object> objects = new ArrayList();
        objects.add(100);
        objects.add("100");
        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        String s = (String) objects.get(0);
        String s1 = (String) objects.get(1);
    }
}
