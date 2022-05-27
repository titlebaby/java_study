package com.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        /**
         * 1. 连接服务端（ip 端口）
         * 解读： 连接本机的9999 端口，如果连接成功，返回Socket 对象
         *
         */
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客服端 socket 返回="+ socket.getClass());
        /**
         * 2. 连接上后，生成Socket， 通过socket。getOutputStream()
         * 得到 和 socket对象关联的输出流对象
         */
        OutputStream outputStream = socket.getOutputStream();


        /**
         * 3. 通过输出流，写入数据到数据通道
         */
//        outputStream.write("hello server".getBytes());
        /**
         * 3. 通过输出流，写入数据到数据通道, 使用字符流
         */
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server 字符流");
        bufferedWriter.newLine();// 插入一个换行符，表示写入的内容结束， 注意，要求对方也要用newLine
        bufferedWriter.flush(); // 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道

        //设置结束标识
//        socket.shutdownOutput();
        /**
         * 4. 获取和socket 关联的输入流，读取数据（字节） 并显示
         */
        InputStream inputStream = socket.getInputStream();
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen= inputStream.read(buf)) != -1) {
//            System.out.println(new String(buf, 0, readLen));
//        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);



        // 5.关闭流对像和socket 必须关闭
//        inputStream.close();
//        outputStream.close();
        //关闭外层流 h后打开的先关闭
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客服端退出......");

    }
}
