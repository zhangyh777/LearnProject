package com.zyh.Tank.TankGame2;

import java.util.Vector;

/**
 * Author:zyh
 * Version:1.0
 */
public class Bomb {
    public int x, y;
    public int life = 9;
    public boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}
