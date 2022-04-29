package com.event_;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {

    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();

    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp); //窗口JFrame可以监听我们的键盘事件，即可以监听到面板发生的键盘事件
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }
}

/**
 * 在面板上绘画小球 并且 移动小球
 * KeyListener 监听器 监听键盘的动作
 */
class MyPanel extends JPanel implements KeyListener {
    //为了让小球移动，把他的左上角的坐标(xy)设置变量
    int x=10;
    int y=10;
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20); //默认时黑色
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * java 事件处理是采取“委派事件模型”。当事件发生时，产生事件的对象。会把此下“信息”传递给“事件的监听者”处理，这里所说的“信息”实际就是java。awt。event
     * 事件类库里某个类所创建的对象，把它称为“事件的对象” 如“KeyEvent”就是一个事件对象，实现了监听器，如“KeyListener”就是一个监听者，如“MyPanel”。
     *
     */

    @Override
    public void keyPressed(KeyEvent e) {
        //根据用户按下的不同键，让小球移动
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;

        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }else if(e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        }
        this.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
