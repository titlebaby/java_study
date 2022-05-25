package com.tankgame03;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class DrawCircle extends JFrame {

    private MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new DrawCircle();

    }


    public DrawCircle() {

        System.out.println("请输入选择 1：新游戏 2 继续上局");
        String key = scanner.next();


        mp = new MyPanel(key);
        new Thread(mp).start();
        //把画板放入窗口中()
        this.add(mp);
        this.setSize(1300, 950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        // 在jframe中增加响应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                Recorder.keepRecord();

                super.windowClosing(e);
            }
        });
    }

}


