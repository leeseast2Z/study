package com.leeseast2Z.generics;

/**
 * @Author: limf
 * @Date: 2021/5/27 15:21
 * @Description:
 */
public class Bean {

    public String name;
    protected String phone;

    public String getName() {
        System.out.println("get in parent ====");
        return name;
    }

    public void setName(String name) {
        System.out.println("set in parent ====");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    protected void call() {
        System.out.println("call in Parent ====");
    }

    public Bean getBean() {
        return this;
    }

    public Bean[] getBeans() {
        return null;
    }
}
