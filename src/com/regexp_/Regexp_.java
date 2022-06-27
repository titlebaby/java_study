package com.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp_ {
    public static void main(String[] args) {
        String str = "本套Java课程为三个阶段，涵盖了Java基础的方方面面。\n" +
                "第一阶段:建立编程思想(包括:基本语法、数组、排序和查找、面向对象编程、零钱通、房屋出租系统、迷宫、八皇后、汉诺塔 )\n" +
                "第二阶段:提升编程能力(包括: 枚举和注解、Exception、常用类、集合、泛型、线程、IO流、坦克大战) \n" +
                "第三阶段: 增强分析需求，代码实现能力(包括: 网络编程、反射、Mysql、JDBC和连接池、正则表达式、Java8 Java11 新特性、马踏棋盘、满汉楼、多用户通信系统)";
        Pattern compile = Pattern.compile("([a-zA-z]+)|([0-9]+)");
        //匹配器对象
        Matcher matcher = compile.matcher(str);
        System.out.println((matcher.find()));
        while (matcher.find()) {
            System.out.println( "找到="+matcher.group(0));
        }
    }
}
