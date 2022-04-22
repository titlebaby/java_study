package com.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArraySortCustom {
    public static void main(String[] args) {
        int[] arr = {1, 8, 0, 20,-1};
        bubble01(arr);
        System.out.println(Arrays.toString(arr));
        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
//                return i1 - i2; //A-B 大于0 成立交换 大的放在右边,小的放在左边, 从小到大
                return i2 - i1; // A-B 小于0 从大到小
            }
        });
        System.out.println(Arrays.toString(arr));
        int index = Arrays.binarySearch(arr , 0); // 二叉查找,要求数组必须是有序的
        // 如果数组中,不存在这个字符,返回,应该存在的位置 +1 取反, -(low+1)
        System.out.println("index==="+index);
        Integer[] arr1 = { -1, 0, 20, 33};
        Arrays.sort(arr1, Collections.reverseOrder());
        int index2 = Arrays.binarySearch(arr1 , 0); // 二叉查找,要求数组必须是有序的
        // 如果数组中,不存在这个字符,返回,应该存在的位置 +1 取反, -(low+1)
        System.out.println("index2="+index2);

        //==============
        int[] newArr = Arrays.copyOf(arr, 3); // 如果copy 长度小于0 返回异常
        // 大于 本来的长度,用"0" 填充
        System.out.println("=======copy=======");
        System.out.println(Arrays.toString(newArr));
        System.out.println("=======fill=======");
        Integer[] num = new Integer[] {99,33,5};
        Arrays.fill(num, 99);
        System.out.println(Arrays.toString(num));

        // 比较两个数组是不是一样
        boolean equals = Arrays.equals(arr1, num);
        System.out.println("equals="+ equals);

        System.out.println("=========list===============");
        List asList = Arrays.asList(2,3,4,5,1);
        System.out.println("aslist = "+ asList);
//        System.out.println("编译类型=" + asList.);
        System.out.println("运行类型=" +  asList.getClass());
    }

    public static void bubble01(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 从小到大
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }

    // 结合冒泡 +  定制
    public static void bubble02(int[] arr, Comparator c) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 从小到大
//                if (arr[j] > arr[j + 1]) {
                if (c.compare(arr[j], arr[j+1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

    }
}
