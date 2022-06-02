package com.reflect_;

import java.lang.reflect.Field;

public class Class02 {



    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String path = "com.reflect_.Dog";

        Class aClass = Class.forName(path);

        System.out.println(aClass.getClass());


        System.out.println(aClass.getPackage().getName());

        System.out.println(aClass.getName());


        Dog dog = (Dog) aClass.newInstance();
        System.out.println(dog);


        // 运用反射修改对象属性

        Field age = aClass.getField("age");

        age.set(dog, 110);
        System.out.println(age.get(dog));


        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }
}
