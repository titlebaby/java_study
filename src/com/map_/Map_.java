package com.map_;

import java.util.HashMap;

public class Map_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        /**
         * map 接口实现类的特点（很实用） jdk8
         * 1. map与collection并列存在，用于保存具有映射关系的数据：key-value
         * 2. map中的key和value可以是任何引用类型的数据，会封装到hashMap $Node 对象中
         *
         * 3. map中的key不允许重复，原因和hashSet 一样
         *
         * 4. map 中的value 可以重复
         *
         * 5. map的key可以为 null，value也可以为null，注意key为 null，只能有一个，value为null 可以有多个
         *
         * 6. 常用string类作为map 的key
         * 7. key 和 value之间存在单向一对一关系，即通过指定的key 总能找到对应的 value
         *
         * 8. map 存放数据的 key-value示意图，一对 k-v 是放在一个 HashMap $Node中的，又
         * 因为  Node 实现了 Entry 接口，有些书上也说 一对 k-v 就是一个 Entry
         *
         * 9 扩容机制差不多和 hashset一样，也是要table扩容到64才会树化
         * 0 -> 16(12)-> 32 (24) ->64 (64 *0.75=48) -> 128 (96)-> 不可以无限扩容 （2^231-1）
         */
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("java",10);
        objectObjectHashMap.put("php",10);
        objectObjectHashMap.put("java",20);

        /**
         * Hashtable 的底层
         * 1. 底层有数组Hashtable$Entry[] 初始化大小为 11
         * 2. 临界值 threshold = = 11 * 0.75
         * 3. 扩容： 按照自己的扩容机制来即可
         * 4. 执行方法 addEntry(hash, key ,calue , index) 添加K-V 封装到Entry
         * 5. 当if （count > threshold）  满足时，就进行扩容 ，
         * 按照int new newCapcity = （newCapcity << 2） +1.(即newCapcity * 2 +1) 的大小扩容
         */


    }
}
