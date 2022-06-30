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

        // 使用正则表达式去重

        String str1= "我我要学学学编程java";

        String content = Pattern.compile("(.)\\1+").matcher(str1).replaceAll("$1");
        System.out.println(content);


        String str2 = "2000年5月JDK1.3,成功将JDK1.4推出";
        String jdk = str2.replaceAll("JDK1.3|JDK1.4", "JDK");
        System.out.println(jdk);

        String str3 = "13883254689";
        boolean matches = str3.matches("1(38|39)\\d(8)");
        System.out.println(matches);


        String str4 = "hello#abc-jdk~背景";
        String[] split = str4.split("#|-|~|\\d+");
        for (String s : split) {
            System.out.println(s);
        }


    }

}
