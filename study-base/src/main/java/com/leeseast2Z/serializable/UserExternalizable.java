package com.leeseast2Z.serializable;

import java.io.*;

/**
 * @Author: limf
 * @Date: 2021/5/28 10:11
 * @Description: 序列化测试对象实现Externalizable
 */
public class UserExternalizable implements Externalizable {
    private String name;
    private String pwd;
    private transient String token;

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(token);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        token = (String) in.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
