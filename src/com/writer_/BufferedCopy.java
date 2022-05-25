package com.writer_;

import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "e:\\a.txt";
        String desFilePath = "e:\\b.txt";
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter = new BufferedWriter(new FileWriter(desFilePath));
            //不操作二进制文件
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }

    }
}
