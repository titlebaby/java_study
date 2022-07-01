package com.api;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DESKTOP-SLDT9DS/172.27.96.1

        InetAddress byName = InetAddress.getByName("DESKTOP-SLDT9DS");
        System.out.println(byName); //DESKTOP-SLDT9DS/172.27.96.1

        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println(byName1);

        //
        String hostAddress = byName1.getHostAddress();
        System.out.println(hostAddress);

        String hostName = byName1.getHostName();
        System.out.println(hostName);
    }
    @Test
    public void test01() {
        char c1 = 'a';
        char c2 = '\t';
        char c3 = '韩';
        char c4 = 97;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}
