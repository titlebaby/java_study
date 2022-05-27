package com.socket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        // 1. 创建一个DatagramSocket
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        //2 构建一个  最大的数据包是64k
        byte[] bytes = new byte[1024*64];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //3. 调用接受方法
        // 当有数据包发送到本机的9999端口 就会接收数据，如果没有数据包发送到，本机的9999端口 就会阻塞
        datagramSocket.receive(datagramPacket);

        //4 拆包 packet
        int length = datagramPacket.getLength();// 实际接收到的数据字节长度
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);



        byte[] data1 = "好的，明天见".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet =
                new DatagramPacket(data1, data1.length, InetAddress.getByName("192.168.111.115"), 9998);
        datagramSocket.send(packet);

        datagramSocket.close();

        System.out.println("A关闭");

    }
}
