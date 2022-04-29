package com.tankgame03;

public class Shot implements Runnable {
    int x;
    int y;

    int direct = 0;
    int speed = 1;

    boolean isLive = true;

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void run() {
        //射击
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 根据方向设置坐标
            switch (direct) {
                case 0: //上
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            System.out.println("x" + x + "   y=" + y);
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive) ) {
                isLive = false;
                break;
            }
        }

    }
}
