package com.leeseast2Z.generics;

import java.lang.reflect.Array;

/**
 * @Author: limf
 * @Date: 2021/5/27 17:12
 * @Description: 泛型数组
 */
public class GenericArray<T> {
    private T[] array;

    public GenericArray(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T t) {
        array[index] = t;
    }

    public T get(int index) {
        return array[index];
    }
}
