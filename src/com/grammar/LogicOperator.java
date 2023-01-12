package com.grammar;

public class LogicOperator {
    public static void main(String[] args) {
        int age =50;
        //短路与
        if (age > 20 && age <90) {
            System.out.println("ok 100");
        }
        // 逻辑与
        if (age > 20 & age <90) {
            System.out.println("ok 200");
        }

        // 区别
        int a = 4;
        int b =9;
        //  && 对于短路与，如果第一个条件是false，后面的条件将不会执行
        if (a < 1 && ++b <50) {
            System.out.println("ok 300");
        }
        System.out.println("a="+a + " b="+b);
        //  &  对于逻辑与而言，如果第一个是false，后面的条件还是会执行
        if (a < 1 & ++b <50) {
            System.out.println("ok 300");
        }
        System.out.println("a="+a + " b="+b);


        int x =5;
        int y =5;
        if (x++ ==6 & ++y == 6) {
            x=11;
        }
        // 后 ++ ，是先赋值或者比较，在自增
        System.out.println("x=" + x +" y= "+ y);
    }
}
