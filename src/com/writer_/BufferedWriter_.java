package com.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\ok.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hello ,hsp education");
        // 插入一个和系统相关的换行符
        bufferedWriter.newLine();
        bufferedWriter.write("hello ,hsp education");
        // 一定要关闭这个流 不然写不进去
        bufferedWriter.close();
    }
}
