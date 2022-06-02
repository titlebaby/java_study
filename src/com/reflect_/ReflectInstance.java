package com.reflect_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectInstance {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String path = "com.reflect_.Dog";

        Class aClass = Class.forName(path);


        Object o1 = aClass.newInstance();

        System.out.println(o1);

        // 有参数构造器，先得到构造器 再传入实参
        Constructor constructor = aClass.getConstructor(int.class);
        Object o = constructor.newInstance(20);

        System.out.println(o);


        //私有构造器

        Constructor declaredConstructor = aClass.getDeclaredConstructor(Integer.class, Integer.class);

        declaredConstructor.setAccessible(true); //使用爆破，使用反射可以方位private的构造器(对于属性也可以进行爆破)
        Object o2 = declaredConstructor.newInstance(100, 1000);
        System.out.println(o2);


    }
}
