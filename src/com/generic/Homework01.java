package com.generic;

import java.util.ArrayList;
import java.util.Comparator;

public class Homework01 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 20000, new MyDate(2000,10,1)));
        employees.add(new Employee("jack", 20000, new MyDate(1980,11,1)));
        employees.add(new Employee("jack", 20000, new MyDate(2010,10,1)));
        System.out.println("employees=" + employees);
        System.out.println("============排序结果===============");


        /**
         * 创建该类的3个对象，把对象放入ArrayList集合中（要用泛型） 对集合中元素进行排序
         * 先按照name 后按照生日
         */
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
               int i = o1.getName().compareTo(o2.getName());
               if(i != 0) {
                   return i;
               }
               return o1.getBirthday().compareTo(o2.getBirthday());
//               int year = o1.getBirthday().getYear() - o2.getBirthday().getYear();
//                if(year != 0) {
//                    return year;
//                }
//                int month = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
//                if(month != 0) {
//                    return month;
//                }
//
//                return o1.getBirthday().getDay() - o2.getBirthday().getDay();
            }
        });
        System.out.println("employees=" + employees);

    }
}
