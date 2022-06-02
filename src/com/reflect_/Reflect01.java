package com.reflect_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflect01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();

//        Dog dog = new Dog();

        //加载类，返回Class类型的对象aClass
        Class aClass = Class.forName(classfullpath);
        //通过 aClass 得到你加载的类 Dog 的对象实例
        Object o = aClass.newInstance();
        //通过aClass 得到你加载的类 的方法
        Method method1 = aClass.getMethod(method);
        // 通过得到的方法 method1 调用方法 invoke ：即通过方法来实现调用方法
        method1.invoke(o);

        // reflect 不能得到私有的属性，只能得到共有
        Field age = aClass.getField("age");
        System.out.println(age);

        Constructor constructor = aClass.getConstructor();
        System.out.println(constructor);

        Constructor constructor1 = aClass.getConstructor(Integer.class);
        System.out.println(constructor1); // 构造器是可以在调用更多的方法

        // =====reflect 反射的好处是，不需要修改源码，只需要修改配置文件，就可以实现功能的扩展=====
        /**
         * 1. 有点
         *  可以动态的创建和使用对象（也是框架的核心），使用灵活，没有反射制，框架技术就失去底层支撑
         *
         * 2 缺点
         *  使用反射基本是解释执行，对执行速度有影响
         */



    }
}
