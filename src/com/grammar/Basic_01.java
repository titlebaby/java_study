package com.grammar;

public class Basic_01 {
    public static void main(String[] args) {
        char[] chars = new char[26];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('A' + i);
//            System.out.println(chars[i]);
        }
        System.out.println("==========求最大========");
        int[] arrMax = {4, -1, 91, 10, 5};
        int index_ = 0;
        int max_ = arrMax[index_];
        for (int i = 0; i < arrMax.length; i++) {
            if (max_ < arrMax[i]) {
                max_ = arrMax[i];
                index_ = i;
            }
        }
        System.out.println("max=" + max_ + " index=" + index_);


        System.out.println("=======基本数据赋值======");
        //基本数据类型赋值，是值拷贝
        // 数组再默认情况下是引用传递，赋的值是地址，赋值方式为引用传递

        int[] arrQuote1 = {1, 2, 3};
        int[] arrQuote2 = arrQuote1;
        arrQuote2[0] = 10;
        System.out.println(arrQuote1[0]);

        System.out.println("===数组反转===");
        int[] arrReverse = {1, 2, 9};
        int len = arrReverse.length;
        int temp = 0;
        for (int i = 0; i < len / 2; i++) {
            temp = arrReverse[len - 1 - i];
            arrReverse[len - 1 - i] = arrReverse[i];
            arrReverse[i] = temp;
        }

        int[] arrExtend = {1, 2, 3};
        int[] arrExtendNew = new int[arrExtend.length + 1];
        System.out.println(arrExtendNew.length);
        arrExtendNew = arrExtend; // 指向了老数组地址
        System.out.println(arrExtendNew.length);
        System.out.println("=====");
        for (int i = 0; i < arrExtendNew.length; i++) {
            System.out.print(arrExtendNew[i]);
        }
        System.out.println();
        arrExtendNew[arrExtendNew.length - 1] = 4;
        for (int i = 0; i < arrExtendNew.length; i++) {
            System.out.println(arrExtendNew[i]);
        }

        System.out.println("====二维数组=====");

        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                arr[i][i1] = i1 + 10;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                System.out.print(arr[i][i1] + " ");
            }
            System.out.println();

        }


        System.out.println("======杨辉三角======");
        int[][] yangHui = new int[10][];
        for (int i = 0; i < yangHui.length; i++) {
            yangHui[i] = new int[i + 1];
            for (int i1 = 0; i1 < yangHui[i].length; i1++) {
                if (i1 == 0 || yangHui[i].length -1 == i1) {
                    yangHui[i][i1] = 1;
                } else {
                    yangHui[i][i1] = yangHui[i-1][i1-1] + yangHui[i-1][i1];
                }
            }
        }

        for (int i = 0; i < yangHui.length; i++) {
            for (int i1 = 0; i1 < yangHui[i].length; i1++) {
                System.out.print(yangHui[i][i1] + " ");
            }
            System.out.println();

        }


    }
}
