package com.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {


    public static void main(String[] args) throws IOException {
        //1. 本机的9999端口监听，等待链接，
        // 细节： 要求在本机没有其它服务在监听9999 否则会报错
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在监听9999端口 等待链接");// 没有客户端链接，服务端会阻塞在这里，不会往下面执行
        //2. 当没有客户端链接9999端口时，程序会阻塞，等待链接
        //    如果有客户端链接，则会返回socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("socket="+socket.getClass());
        //3. 通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        //4. Io读取
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf)) != 1) {
//            System.out.println(new String(buf, 0 , readLen));
//        }

        //字符流  转换流 InputStreamReader 把 inputStream转成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        System.out.println("客户端说完话了");
        //5. 获取socket相关的输出流
        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello ,client".getBytes());

        //使用字符输出流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();// 需要手动刷新，不然不会写到数据通道
        //设置结束标识
//        socket.shutdownOutput();

        //6. 关闭流和socket
//        inputStream.close();
//        outputStream.close();
        bufferedWriter.close();
        bufferedReader.close();

        socket.close();
        serverSocket.close();



    }
}
