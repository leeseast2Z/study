package com.test.exception;

import com.google.common.collect.Maps;

import java.util.HashMap;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @Author: limf
 * @Date: 2021/5/26 16:28
 * @Description: Test
 */
public class Main {
    public static void main(String[] args) {
        String str = null;
        // Preconditions.checkNotNull(str, "str为NULL", "1", "2");
        HashMap<Object, Object> errorMap = Maps.newHashMap();
        errorMap.put("name", "不为NULL");
        errorMap.put("phone", "不为NULL");
        // 希望errorMap为空，否则输出错误信息
        checkArgument(errorMap==null, "参数校验如下：%s", errorMap);
        System.out.printf("x=%d,%d,%s", 1 , 2, 3);
    }
}
