package com.leeseast2Z.convert;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @Author: limf
 * @Date: 2021/6/4 15:09
 * @Description:
 */
public class HtmlConvert {
    public static void main(String[] args) {
       /* Class<? extends Class> aClass = A.class.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            int modifiers = field.getModifiers();
            if(!Modifier.isFinal(field.getModifiers()) && type == String.class) {
                System.out.println("modifiers = " + Modifier.toString(modifiers));
                System.out.println("OMG~~");
            }
        }*/

        try {
            // 可以获取到父类的属性
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("uid", A.class);
            Method readMethod = propertyDescriptor.getReadMethod();

            System.out.println("readMethod.getName() = " + readMethod.getName());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    public class Parent {
        private String uid;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }

    public class A extends Parent{
        private boolean flag;
        private String name;
        public static final String SEL_POWER_1 = "1"; //看自己+内部审计

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
