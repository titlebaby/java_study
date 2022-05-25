package com.reader_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\a.txt";
        //创建 bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        // 读取
        String line; //按行读取，效率高
        // 如果读完，返回null
        while ( (line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭流，这里注意，只需要关闭 bufferedReader ， 因为底层会自动关闭

        bufferedReader.close();

    }
}
