package com.regexp_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp02_ {
    public static void main(String[] args) {
        //规定电子邮件规则为
        // 只能有一个@
        // @前面是用户名，可以是数字字母下划线中划线
        // @后面是域名，并且域名只能是英文字母，比如sohu.com
        // 判断是否满足
        String str = "ll@shu.com";
        String s = "[a-zA-Z0-9_-]@[a-z.]a-z";
        String s1 = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
//        Pattern pattern = Pattern.compile(s1);
//        Matcher matcher = pattern.matcher(str);
//        if (matcher.find()) {
//            System.out.println("满足");
//        } else {
//            System.out.println("不满足");
//        }
        // String的 matches 是整体匹配
        if (str.matches(s1)) {
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败~");
        }


        String str2 = "-01.89";//00.231
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        if (str2.matches(regStr)) {
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败~");
        }


        String str3 = "http://www.baidu.com:8080/abc/index.html";
        String regStr2 = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.@#$%]+)$";
        if (str3.matches(regStr2)) {
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败~");
        }
    }
}
