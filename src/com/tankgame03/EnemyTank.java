package com.tankgame03;

import java.util.Vector;

public class EnemyTank extends Tank{
    boolean isLive = true;
    Vector<Shot> enemyShot = new Vector<>();
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
