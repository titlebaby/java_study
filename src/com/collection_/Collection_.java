package com.collection_;

import String.demo.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Collection_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        /**
         * 1. collection实现子类可以存放多个元素，每个元素可以是object
         * 2. 有些collection的实现类，可以存放重复的元素，有些不可以
         * 3. 有些collection的实现类，有些是有序的list，有些不是有序 set
         * 4. collection接口没有直接的实现子类，是通过它的子接口set和list来实现的
         */
        List col = new ArrayList();
        col.add("jack");
        col.add(123);
        col.add(true);
        System.out.println("list=" + col);//这里是对象了
        col.remove("jack");
        /**
         * add
         * remove
         * contains 是否存在
         * size
         * isEmpty
         * clear  清空
         * addAll
         * containsAll
         * removeAll
         */
        //==========迭代器===========
        /**
         * iterator 用于遍历collection集合元素
         * 1. iterator 对象称为迭代器，主要用于遍历collection 集合中的元素
         * 2. 所有实现了collection接口的集合类都有一个iterator()方法，用以返回一个实现了iterator接口的对象，即可以返回一个迭代器
         * 3. iterator仅用于遍历集合，iterator本身并不存放对象
         */
        iterator_();
    }

    @SuppressWarnings({"all"})
    public static void iterator_() {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", 120));
        col.add(new Book("红楼梦", 110));
        col.add(new Book("西游记", 180));
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next(); //编译类型是Oject， 运行类型要看实际运行的对象，这里是book
            System.out.println("obj=" + obj);
        }
        //上面的while的快捷键 itit 回车
        // 显示所有的快捷键的快捷键 ctrl + j
        // 当推出while 循环后，这时迭代器iterator，指向最后的元素，iterator.next() 这是会抛异常
        // so 如果希望再次遍历，需要重置我们的迭代器
        iterator = col.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next(); //编译类型是Oject， 运行类型要看实际运行的对象，这里是book
            System.out.println("第二次遍历obj=" + obj);
        }
        //================================
        System.out.println("============增强for 底层还是iterator=================");
        for (Object book : col) {
            System.out.println("book=" + book);
        }
        // 快捷键 I + inter
        Integer[] num =  {1,4,3,2};
        for (Object o : num) {
            System.out.println("o=" + o);

        }


    }

}
