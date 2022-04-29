package com.draw;


import javax.swing.*;
import java.awt.*;

/**
 * 实现坦克的绘画
 * 1. 先定义一个MyPanel 继承Jpanel类，画图形，就在画板上画。
 * 2. MyPanel 对象就相当于花瓣
 * <p>
 * 3. Graphics g =》笔 Graphics 有很多画图的方法
 */

public class MyPanel extends JPanel {
    Hero  hero = null;
    public MyPanel() {
        hero = new Hero(100,100);//初始化自己坦克
    }

    @Override
    public void paint(Graphics g) { // =>绘制组件的外观
        //绘画方法
        super.paint(g);
        g.fillRect(0, 0, 1000, 700);
        drawTank(hero.getX(), hero.getY(), g, 0,1);
        drawTank(hero.getX() + 60, hero.getY(), g, 0,0);
        //画一个圆形
//        g.drawOval(10,10,100,100);
//        //演示绘制不同的图形
//        g.drawLine(10,10,100,100);
//        g.drawRect(10,10,100,100);
//        g.setColor(Color.RED);
//        g.fillRect(10,10,100,100);
        //“/”表示项目的根目录 image 放在src目录
//        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bg.png"));
//
//        g.drawImage(image, 0, 0, 1252,221,this);

    }

    /**
     * paint什么时候会被调用
     * 1。 当组件第一次在屏幕显示的时候，程序会自动的调用paint()方法来绘制组件
     * 2. 以下情 paint() 将会被调用
     * 2.1 窗口最小化，再最大化
     * 2.2 窗口的大小大圣杯变化
     * 3.repaint 函数被调用（repaint()=>刷新组件外观）
     */

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向，；来绘制坦克；
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 20, false);
                g.fillRect(x + 10, y + 20, 20, 20);
                g.drawLine(x +  20, y+30,x+20, y);//画炮

                break;
            default:
                System.out.println("暂时没有处理~");
                break;
        }
    }

}
