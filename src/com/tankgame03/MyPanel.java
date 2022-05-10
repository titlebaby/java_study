package com.tankgame03;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;


/**
 * 实现坦克的绘画
 * 1. 先定义一个MyPanel 继承Jpanel类，画图形，就在画板上画。
 * 2. MyPanel 对象就相当于花瓣
 * <p>
 * 3. Graphics g =》笔 Graphics 有很多画图的方法
 */


// 为了让panel 不停的重绘子弹，需要将myPanel做成一个线程 ！！！！！Runnable ,因为如果不是线程paint只会调用一次
public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(500, 100);//初始化自己坦克
        hero.setSpeed(5);
        //初始化
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDirect(2); //设置敌人坦克方向
            //启动敌人坦克线程，让他动动起来
            new Thread(enemyTank).start();
            //给该enemyTank添加一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.enemyShot.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);

        }
    }

    @Override
    public void paint(Graphics g) { // =>绘制组件的外观
        //绘画方法
        super.paint(g);
        g.fillRect(0, 0, 1000, 700);
        if(hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //drawTank(hero.getX() + 60, hero.getY(), g, 0,0);

        //画子弹
      /*  if (hero.shot != null && hero.shot.isLive) {
            System.out.println("字段被绘制~~");
            g.fillRect(hero.shot.x, hero.shot.y, 1, 1);
        }*/
        //可以打多个子弹，按一次添加个子弹，每次再重（这里是个多线程）绘每颗子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.fillRect(shot.x, shot.y, 1, 1);
            } else {
                hero.shots.remove(shot);
            }

        }

        //画出敌人的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {

            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //画出enemyTank所有子弹
                System.out.println("坦克的子弹数i=" + i + " -> " + enemyTank.enemyShot.size());
                for (int j = 0; j < enemyTank.enemyShot.size(); j++) {
                    Shot shot = enemyTank.enemyShot.get(j);
                    if (shot.isLive) {
                        g.fill3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        //移除
                        enemyTank.enemyShot.remove(shot);
                    }

                }
            }

        }
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
            case 0: //向上
                g.fill3DRect(x, y, 10, 60, false);//左轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); //画圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画炮

                break;
            case 1: //向右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画炮

                break;
            case 2: //向下
                g.fill3DRect(x, y, 10, 60, false);//左轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); //画圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画炮

                break;
            case 3: //向左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);//画炮
                break;
            default:
                System.out.println("暂时没有处理~");
                break;
        }
    }
    //一个子弹有没有击中坦克
    public static void hitTank(Shot s, Tank enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0:
            case 2:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;

                }
                break;
            case 1:
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                }
                break;

        }

    }

    public void hitHero(){
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.enemyShot.size(); j++) {
                //取出子弹
                Shot shot = enemyTank.enemyShot.get(j);
                //判断是否击中坦克
                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }

        }
    }

    public void hitEnemyTank(){
        //单科子弹
        if (hero.shot != null && hero.shot.isLive) {
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(hero.shot, enemyTank);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLift();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDirect(0);
            if (hero.getY() > 0) {
                hero.moveUp();
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("用户按下J");
//            if (hero.shot == null || !hero.shot.isLive) {
                hero.shotEnemyTank();
//            }

        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        //每个100毫秒，重绘子弹（因为子弹的 x 和 y都再不听的移动）
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断是否击中敌方
            hitEnemyTank();
            //敌人坦克是否击中我们
            hitHero();
            this.repaint();
        }


    }
}
