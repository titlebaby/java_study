package com.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeworkServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();


        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0 ;
        String fileName = "";
        while ((len = inputStream.read(bytes)) != -1) {
            fileName += new String(bytes, 0 ,len);
        }
        System.out.println("客服端希望下载的文件名=" + fileName);
        String resFileName = "";
        if("bg".equals(fileName)) {
            resFileName= "src\\bg.png";
        }

        //输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        //字节数组
        byte[] bytes1 = StreamUtils.streamToByByteArray(bis);
        //输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes1);
        bos.flush();
        socket.shutdownOutput();

        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}
