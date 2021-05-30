package com.leeseast2Z.serializable;

import java.io.*;

/**
 * @Author: limf
 * @Date: 2021/5/28 10:11
 * @Description: 序列化
 *
 * 序列化对象一般实现Serializable接口，
 * 对于一些属性不希望被序列化，添加上 transient 关键字，该属性不会被序列化
 * transient只能修饰变量，不能修饰类，本地变量native，只能修饰用户自定义变量
 *
 * 对象的序列化可以通过实现两种接口来实现，若实现的是Serializable接口，则所有的序列化将会自动进行，
 * 若实现的是Externalizable接口，则没有任何东西可以自动序列化，
 * 需要在writeExternal方法中进行手工指定所要序列化的变量，
 * 这与是否被transient修饰无关。因此第二个例子输出的是变量content初始化的内容，而不是null。
 */
public class SerializableMain {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 实现Serializable接口
     */
    public static void test1() {
        UserSerializable user = new UserSerializable();
        user.setName("lee");
        user.setPwd("123456");
        user.setToken("oioioioii");
        System.out.println("serializable= " + user);
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("D:/1.txt"));
            os.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os!=null) {
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("D:/1.txt"));
            UserSerializable readUser = (UserSerializable) oi.readObject();
            System.out.println("readUser = " + readUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现Externalizable接口
     */
    public static void test2() {
        UserExternalizable user = new UserExternalizable();
        user.setName("lee");
        user.setPwd("123456");
        user.setToken("oioioioii");
        System.out.println("serializable= " + user);
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/1.txt"));
            os.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("D:/1.txt"));
            UserExternalizable readUser = (UserExternalizable) oi.readObject();
            System.out.println("readUser = " + readUser);
            // readUser = User{name='null', pwd='null', token='oioioioii'}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
