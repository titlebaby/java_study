package com.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {


    public static void main(String[] args) throws IOException {
        //1. 本机的9999端口监听，等待链接，
        // 细节： 要求在本机没有其它服务在监听9999 否则会报错
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器在监听8888端口 等待链接");// 没有客户端链接，服务端会阻塞在这里，不会往下面执行

        Socket socket = serverSocket.accept();

        //通过socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByByteArray(bis);
        //4 将byte数组，写入到指定的路径，就得到一个文件了
        String desFile = "src\\test.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));
        bos.write(bytes);
        bos.close();


        // 向客户端回复 "收到图片"
        // 通过socket 获取到输出流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush(); // 把数据刷新到数据通道
        socket.shutdownOutput();



        bis.close();
        socket.close();
        serverSocket.close();




    }
}
