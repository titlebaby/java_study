package com.generic;

import String.demo.Book;

import java.util.ArrayList;

public class Generic01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList dogs = new ArrayList();
        dogs.add(new Dog("xiaohuao",10));
        dogs.add(new Dog("xiaohuao",10));
        dogs.add(new Dog("xiaohuao",10));
        dogs.add(new Book("xiaohuao",10)); // 这里不直接报错 =》由此引出泛型
        for (Object o : dogs) {
            Dog dog = (Dog)o; //数据量大了 转型也消耗性能
            System.out.println(dog.getName() + '-' + dog.getAge());
        }

    }
}
