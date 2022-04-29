package com.generic;

import String.demo.Book;

import java.util.ArrayList;

public class Generic02 {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<Dog>(); //定义的时候ArrayList的参数类型是Dog
        dogs.add(new Dog("xiaohuao",10));
        dogs.add(new Dog("xiaohuao",10));
        dogs.add(new Dog("xiaohuao",10));
//        dogs.add(new Book("xiaohuao",10)); // 这里直接报错 添加类型不符合
        for (Dog dog : dogs) {
            System.out.println(dog.getName() + '-' + dog.getAge());
        }

    }
}


