package com.generic;

import java.time.Year;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    @Override
    public int compareTo(MyDate o) {
        int year1 = this.year - o.getYear();
        if(year1 != 0) {
            return year1;
        }
        int month1 = this.month - o.getMonth();
        if(month1 != 0) {
            return month1;
        }

        return this.day - o.getDay();
    }
    /**
     * 泛型细节
     * 1.普通成员可以使用泛型（属性、方法）
     * 2. 使用泛型的数组，不能初始化(因为数组在new的时候们不能确定类型的，无法开辟空间)
     * 3.静态方法中 不能使用类的泛型（因为静态是和类相关，在类加载时，对象还没有创建，所以，如果静态方法和静态属性使用了泛型，JVM就无法完成初始化）
     * 4.泛型类的类型，事在创建对象时确定的（因为创建对象时，需要指定确定类型）
     * 5.如果在创建对象时，没有指定类型，默认为object
     */
}
class Tiger <T, R, M> {
    String name;
    T t; //属性使用泛型
    R r;
    M m;

    public Tiger(String name, T t, R r, M m) { // 构造函数使用反应
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }
}
