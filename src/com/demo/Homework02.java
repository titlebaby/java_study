package com.demo;


public class Homework02 {
    public static void main(String[] args) {
        String name = "huan shun ping";
        printName(name);

    }

    public static void printName(String str) {
        /*
        1. 按照空格分割
        2. sstring[] 进行格式化
        3. 对输入字符串校验
         */
        if(str == null) {
            System.out.println("str 不能为空~");
        }
        assert str != null;
        String[] names = str.split(" ");
        if (names.length != 3) {
            System.out.println("输入的字符有误~");
            return;
        }
        String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
