package com.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        /**
         * 1. 连接服务端（ip 端口）
         * 解读： 连接本机(服务端)的9999 端口，如果连接成功，返回Socket 对象
         *
         */
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客服端 socket 返回=" + socket.getClass());
        /**
         * 2. 连接上后，生成Socket， 通过socket。getOutputStream()
         * 得到 和 socket对象关联的输出流对象
         */

        // 读取磁盘文件的输入流
        String file = "e:\\images.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = StreamUtils.streamToByByteArray(bis);

        //通过socket获取到输出流，将bytes数据发送给服务器端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bis.close();
        bos.flush(); //不加这个就要报错？？？

        socket.shutdownOutput();



        //=====
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);


        bos.close();
        socket.close();



    }
}
