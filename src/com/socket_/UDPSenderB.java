package com.socket_;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        // 1.创建对象 准备发送和接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        //2 将需要发送的数据封包
        byte[] bytes = "hello,明天吃火锅".getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket =
                new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.111.115"), 9999);
        // 发送
        datagramSocket.send(datagramPacket);
        System.out.println("B端发送：hello,明天吃火锅");


        //接受A的回答
        byte[] buf = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3. 调用接受方法
        // 当有数据包发送到本机的9999端口 就会接收数据，如果没有数据包发送到，本机的9999端口 就会阻塞
        datagramSocket.receive(packet);

        //4 拆包 packet
        int length = packet.getLength();// 实际接收到的数据字节长度
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        datagramSocket.close();
        System.out.println("B关闭");

    }
}
