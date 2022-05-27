package com.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HomeworkClient {
    public static void main(String[] args) throws IOException {
        //1. 接受用户输入，指定下载文件名

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名");
        String fileName = scanner.next();


        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(fileName.getBytes());

        outputStream.flush();
        socket.shutdownOutput();

        //4 读取服务端返回的文件（字节数组）
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        byte[] bytes = StreamUtils.streamToByByteArray(bis);

        String filePath = "e:\\"+fileName+".png";

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);



        bos.close();
        bis.close();
        outputStream.close();
        socket.close();

        System.out.println("客户端下载完毕");



    }
}
