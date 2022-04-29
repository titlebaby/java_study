package com.tankgame02;

import javax.swing.*;

public class DrawCircle extends JFrame {

    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();

    }



    public DrawCircle() {
        mp = new MyPanel();
        //把画板放入窗口中()
        this.add(mp);
        this.setSize(1500, 1300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}


