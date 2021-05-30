package com.leeseast2Z.generics;

/**
 * @Author: limf
 * @Date: 2021/5/27 15:20
 * @Description: 泛型
 */
public class Generic<C> {
    private C obj;

    public C getObj() {
        return obj;
    }

    public void setObj(C obj) {
        this.obj = obj;
    }
}
