package com.set;

import String.demo.Book;

import java.util.HashSet;

public class HashSet_ {
    public static void main(String[] args) {
        /*
        set 接口实现类-HashSet
        1. HashSet 底层是HashMap
        2.添加一个元素时，先得到hash值，-会转成->索引值
        3.找到存储数据表table，看这个索引位置是否已经存放的元素
        4.如果没有，直接加入
        5.如果有，调用equals比较，如果相同，就放弃添加，如果不想通过，则添加到最后
        6.在java8中，如果一天链表的元素个数到TREEIFY_THRESHOLD=8，并且table的大小》=MIN_TREEIFY_CAPACITY=64
        就会进行树化（红黑树），最早是15个table,没有到64前（到12（12个元素，add1个值＋1））
        table都可以扩容，（n - 1) & hash n=table.length,hash值就变了(全部存到这个变之后的table的新索引中了)。
        图分析见"工作经验总结"=>"hashset底层机制.png"=>P523
         */
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        hashSet.add(new String("java"));
        hashSet.add(new String("java"));
        hashSet.add(new Book("书名", 31));
        hashSet.add(new Book("书名", 31));
        System.out.println(hashSet);
        String java1 = new String("java1");
        String java2 = new String("java1");
        System.out.println( "string=" +java1== java2);
    }
}
