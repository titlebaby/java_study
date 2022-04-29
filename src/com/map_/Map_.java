package com.map_;

import java.util.HashMap;
import java.util.TreeSet;

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
         * 按照int new newCapcity = （newCapcity << 1） +1.(即newCapcity * 2 +1) 的大小扩容
         */
        int newCapcity =3;
        int a = newCapcity << 2;
        System.out.println(a);
        int a1 = newCapcity << 3;
        System.out.println(a1);
        int a2 = newCapcity << 4;
        System.out.println(a2);
        /**
         *  M << n => M * 2^n
         *  左位移n位，就是n个2相乘，2^n，但是有边界：移动的位置超过了本身的字节位数，数字会取模
         */
        int a5 = newCapcity << 29;
        System.out.println(a5);
        int a4 = newCapcity << 31;
        System.out.println(a4);
        int a6 = newCapcity << 32;
        System.out.println(a6);
        int a3 = newCapcity << 33;
        System.out.println(a3);
        /**
         *  x >> n 意思是x向右移动了n个.一般结果是x除以2的y次方. =>x / 2^n
         *
         */

        /**
         * 如果选择集合实现类（重点）
         * 在开发中，选择什么集合实现类，主要取决于业务操作特点，然后根据集合实现类特性进行选择，分析如下：
         * 1. 先判断存储的类型（ 一组对象【单列】或者一组键值对【双列】）
         *
         *  2. 一组对象【单列】： collection接口
         *      允许重复： list
         *          增删多： LinkList[底层维护了一个双向链表]
         *          改查多： ArrayList[底层维护 object类型的可变数组]
         *      不允许重复：set
         *          无序： HashSet[底层是HashMao，维护了一个哈希表，即（数组 + 链表 + 红黑树）]
         *          排序： TreeSet
         *          插入和取出顺序一致，LinkedHashSet【底层是linkhashmap，它的底层是HashMap】 维护数组 + 双向链表
         * 3. 一组简直对： Map
         *      键无序： HashMap[底层是：哈希表 jdk7： 数组 + 链表， jdk8 数组+链表+红黑树]
         *      键排序： TreeMap
         *      键插入和取出顺序一致 ： LinkedHashMap
         *      读取文件 Perperties
         */

        TreeSet<Object> objects = new TreeSet<>();
        objects.add("php");
        objects.add("java");
        objects.add("php");


        objects.add(new Person("张三"));
        objects.add(new Person("李四"));
        System.out.println(objects);
        /**
         * 1. 是分析Hash和TreeHash分别如何实现去重？
         * 答： 1)HashSet的去重机制，hashCode() + equals(), 底层先通过存入对象，进行运算得到一个hash值，
         * 通过hash值得到对应的（table的索引）索引，如果发现table 索引所在的位置，没有数据，就直接存放，如果有数据，
         * 就进行equals（equals可以重写）比较，如果比较后（表里李彪），不相同就加入，否则就不加入。
         *      2)TreeHash的去重机制，如果你传入了一个Comparator匿名对象，就使用传入实现的compare去虫，
         *      如果方法返回0（如例子中的person类 返回的是0），就认为是相同的元素/数据，就不添加，如果你没有传入一个comparator匿名对象，则
         *      以你添加的对象实现的compareable接口的compareTo去重。入添加的是字符串，字符串String的compareTo比较的是内容
         *      重复的内容就添加不进去。
         *
         *
         */


    }


}

class Person implements Comparable {


    private String name;
    public Person(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


/**
 *              底层结构        版本          线程安全（同步）        扩容
 * ArrayList    可变数组        jdk102       不安全，效率高            如果使用有参构造器1.5倍；如果是无参构造器：1.第一次扩容10第二次开始按1.5倍
 * Vector       可变数组        jdk1.0        安全，效率不高           如果是指定大小创建，Vector则每次按照2倍扩容，如果是无惨，默认10，满后按照2倍扩容
 *              object[]
 */
