package com.demo;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayMethod01 {
    public static void main(String[] args) {
        Integer[] arr = {1,20,3,490,50};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        // 调用定制排序，传入两个参数??? HSP P482
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
