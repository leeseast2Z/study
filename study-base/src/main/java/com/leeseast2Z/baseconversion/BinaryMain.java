package com.leeseast2Z.baseconversion;

/**
 * @Author: limf
 * @Date: 2021/5/28 14:22
 * @Description: 二进制
 */
public class BinaryMain {
    public static void main(String[] args) {
        String string = Integer.toString(10, 2);
        System.out.println("string = " + string);
        String str = "1010";
        int parseInt = Integer.parseInt(str, 2);
        int anInt = Integer.parseUnsignedInt(str, 2);
        System.out.println("parseInt = " + parseInt);
        System.out.println("anInt = " + anInt);
    }
}
