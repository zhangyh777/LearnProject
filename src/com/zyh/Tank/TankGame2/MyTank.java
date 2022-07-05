package com.zyh.Tank.TankGame2;


import java.util.Vector;

public class MyTank extends Tank {
    //坦克具有子弹对象(单发子弹)，才能发射子弹（启动子弹线程）
    Bullet bullet = null;
    //多发子弹
    Vector<Bullet> myBullet = new Vector<>();

    public MyTank(int x, int y) {
        super(x, y);
    }

    //射击行为
    public void shotEnemy() {

        //根据坦克位置创建子弹对象
        switch (getDirection()) {
            case 0:
                bullet = new Bullet(getX() + 20, getY() - 10, getDirection());
                break;
            case 1:
                bullet = new Bullet(getX() + 20, getY() + 50, getDirection());
                break;
            case 2:
                bullet = new Bullet(getX() - 10, getY() + 20, getDirection());
                break;
            case 3:
                bullet = new Bullet(getX() + 50, getY() + 20, getDirection());
                break;
        }
        //我方坦克最多一次发射三颗子弹
        if (myBullet.size()<3){
            myBullet.add(bullet);
        }
        new Thread(bullet).start();

    }
}
