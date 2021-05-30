package com.leeseast2Z.generics;

/**
 * @Author: limf
 * @Date: 2021/5/27 15:25
 * @Description: bean子类
 */
public class BeanChild extends Bean {

    private String name;
    private String phone;

    @Override
    public String getName() {
        System.out.println("get in child ====");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println("set in child ====");
        super.setName(name);
        this.name = name;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    protected void call() {
        System.out.println("call in child ======");
    }

    public void call2() {
        System.out.println("call2=====");
    }

    @Override
    public BeanChild getBean() {
        return this;
    }

    @Override
    public BeanChild[] getBeans() {
        return null;
    }
}
