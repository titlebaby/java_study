package com.list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        list.add(1,"hspjy");// 2号位置增加一个元素
        System.out.println(list);
        list.set(0, "xiugai");
        System.out.println(list);
        //==========ArrayList底层结构=============
        /**
         * 1. ArrayList 中维护了一个Object类型的数组elementData
         * transient Object[] elementDta// transient 表示瞬间，短暂的，表示该属性不会被序列化
         *
         * 2. 当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData 容量为0，第1次添加，
         * 则扩容elementData为10，如需要再次扩容， 则扩容elementData为1.5倍
         *
         * 3. 如果使用的是指定大小的构造器，则初始elementData 容量为指定大小，如果需要扩容，则
         * 直接扩容elementData的1.5倍
         */


    }
}
