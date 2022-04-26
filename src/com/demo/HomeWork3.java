package com.demo;

public class HomeWork3 {
    public static void main(String[] args) {
        String str = "45566sdasdq1122";
        countStr(str);
        String str1 = "ASDFGHJ";
        String str2 = reverse(str1, 1,4);
        System.out.println("反转后=" + str2);
    }

    //计算字符串中数字的阁主
    public static void countStr(String str) {
        if (str == null) {
            System.out.println("输入不能为null");
            return;
        }
        int count = 0;
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') { //这里只读出字符串的位置
                count++;
            }
        }
        System.out.println("数字有=" + count);
    }

    //指定范围开始翻转
    public static String reverse(String str, int start, int end) {
        //找出正确的情况，再取反
        if (!(str != null && start >= 0 && end > start && end < str.length() - 1)) {
            throw new RuntimeException("参数不正确~");
        }

        char[] chars = str.toCharArray(); //因为chars数组是可以交换的
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //chars 重新构建字符串
        return new String(chars);
    }
}
