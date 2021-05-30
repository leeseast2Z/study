package com.leeseast2Z.generics;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: limf
 * @Date: 2021/5/27 15:22
 * @Description: 测试类
 *
 * 泛型方法
 * 方法修饰符和返回值之间的<T>声明这是一个泛型方法
 * 表明方法将使用泛型类型T，此时才可以在方法中使用T
 *
 * 子类继承父类的所有属性和方法，但是无法访问父类的私有方法和属性
 *
 * 方法=访问修饰符+返回值+方法签名
 * 方法签名=方法名称+参数列表（顺序&类型）,注意不包含返回值
 * 方法签名是一个方法在一个类中的唯一标识
 *
 * 重写和重载
 * 重写：前提是继承，要求 1.方法签名一样 2.修饰符范围不能比父类低  public>protected>private
 * 子类替换父类方法
 * 父类：如果是private，那么子类就不存在重写，只是新建了个方法。
 *
 * 协变返回类型：子类重写父类方法，返回值可以是父类方法的子类
 * 协变：父类引用可以指向子类对象
 * 数组是可以协变的
 * 泛型不支持协边，编译就会报错
 *
 * 重载要求方法名相同，参数列表和返回值随便改
 * 新加了一个方法
 */
public class GenericsMain {

    public static void main(String[] args) {
       /* Generic<Bean> beanGeneric = new Generic<Bean>();
        Bean beanChild = new BeanChild();
        beanChild.setName("1321");// 调用子类方法
        beanGeneric.setObj(beanChild);
        System.out.println("beanChild.name = " + beanChild.name);// 访问父类
        test(beanGeneric);
        sout(0.99);*/

        // 数组支持协变，泛型不支持（编译报错）
        /*Bean[] beans = new BeanChild[1];
        GenericArray<Bean> beanGenericArray2 = new GenericArray<Bean>(BeanChild.class, 1);*/

        // 泛型数组
       /* GenericArray<Bean> beanGenericArray = new GenericArray<Bean>(Bean.class, 1);
        Bean bean = new Bean();
        bean.setName("lhd");
        beanGenericArray.put(0, bean);
        System.out.println("beanGenericArray.get(0).getName() = " + beanGenericArray.get(0).getName());
        int[] ints = new int[1];
        Integer[] ints1 = (Integer[]) Array.newInstance(Integer.class, 1);
        // java.lang.ClassCastException: [Ljava.lang.Integer; cannot be cast to [I
        // int[] ints2 = (int[]) Array.newInstance(Integer.class, 1);
        ints[0] = 1;
        ints1[0] = 2;
        System.out.println("ints1[0] = " + ints1[0]);*/

        // 上下边界限定符
        boundary();
    }

    public static void test(Generic<? extends Bean> beanGeneric) {
        Bean obj = beanGeneric.getObj();
        obj.call();
        System.out.println("obj.getName() = " + obj.getName());
    }

    public static void test2(Generic<?> beanGeneric) {
        Object obj = beanGeneric.getObj();
        System.out.println("obj = " + obj);
    }

    public static <T> T getObj(Generic<T> tGeneric) {
        T t = tGeneric.getObj();
        return t;
    }

    public static <T> String getType(T t) {
        String result = "";
        if (t instanceof Number) {
            result = "number";
        }else if(t instanceof String) {
            result = "string";
        }
        return result;
    }

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    public static void sout(double d) {
        System.out.println("d = " + d);
        class a{

        }
    }

    public void methodBlock() {
        class MethodBean {
            private String name;
            private String phone;
        }
        MethodBean methodBean = new MethodBean();
        methodBean.name = "123";
        System.out.println("methodBean.name = " + methodBean.name);
    }

    /**
     * 泛型上边界和下边界限定通配符
     */
    public static void boundary() {
        List<? extends Bean> dest = Lists.newArrayList();
        List<? super BeanChild> src = Lists.newArrayList();
        BeanChild beanChild = new BeanChild();
        // dest.add(beanChild); // 编译器报错
        src.add(beanChild);
        // copy(dest, src);
        Bean bean = dest.get(0);
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src)
    {
        for (int i=0; i<src.size(); i++)
            dest.set(i,src.get(i));
    }
}
