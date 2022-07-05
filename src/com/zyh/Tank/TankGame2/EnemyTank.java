package com.zyh.Tank.TankGame2;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    //敌方坦克集合
    Vector<EnemyTank> enemyTankVector = new Vector<>();

    public void setEnemyTankVector(Vector<EnemyTank> enemyTankVector) {
        this.enemyTankVector = enemyTankVector;
    }


    public boolean touch() {
        switch (getDirection()) {
            //上
            case 0:
                //集合里的每辆坦克要和集合里另外的所有坦克相比较
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    EnemyTank e = enemyTankVector.get(i);
                    //不跟自己比较
                    if (this != e) {
                        //上或下
                        if (e.getDirection() == 0 || e.getDirection() == 1) {
                            if ((this.getX() > e.getX()
                                && this.getX() < e.getX() + 40
                                && this.getY() - 10 > e.getY() - 10
                                && this.getY() - 10 < e.getY() + 50)//坦克左上角(x,y-10)
                                || (this.getX() + 40 > e.getX()
                                    && this.getX() + 40 < e.getX() + 40
                                    && this.getY() - 10 > e.getY() - 10
                                    && this.getY() - 10 < e.getY() + 50)//坦克右上角(x+40,y-10)
                            ) {
                                System.out.println("碰撞");
                                return true;
                            }
                        }
                        //左或右
                        if (e.getDirection() == 2 || e.getDirection() == 3) {
                            if ((this.getX() > e.getX() - 10
                                    && this.getX() < e.getX() + 50
                                    && this.getY() - 10 > e.getY()
                                    && this.getY() - 10 < e.getY() + 40)//坦克左上角(x,y-10)
                                    || (this.getX() + 40 > e.getX() - 10
                                        && this.getX() + 40 < e.getX() + 50
                                        && this.getY() - 10 > e.getY()
                                        && this.getY() - 10 < e.getY() + 40)//坦克右上角(x+40,y-10)
                            ) {
                                System.out.println("碰撞");

                                return true;
                            }
                        }
                    }
                }
                break;
            //下
            case 1:
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    EnemyTank e = enemyTankVector.get(i);
                    if (this != e) {
                        if (e.getDirection() == 0 || e.getDirection() == 1) {
                            if ((this.getX() > e.getX()
                                    && this.getX() < e.getX() + 40)
                                    && this.getY() + 50 > e.getY() - 10
                                    && this.getY() + 50 < e.getY() + 50//坦克右下角(x,y+50)
                                    || (this.getX() + 40 > e.getX()
                                        && this.getX() + 40 < e.getX() + 40
                                        && this.getY() + 50 > e.getY() - 10
                                        && this.getY() + 50 < e.getY() + 50)//坦克左下角(x+40,y+50)
                            ) {
                                System.out.println("碰撞");
                                return true;
                            }
                        }
                        if (e.getDirection() == 2 || e.getDirection() == 3) {
                            if ((this.getX() > e.getX() - 10
                                    && this.getX() < e.getX() + 50)
                                    && this.getY() + 50 > e.getY()
                                    && this.getY() + 50 < e.getY() + 40//坦克右下角(x,y+50)
                                    || (this.getX() + 40 > e.getX() - 10
                                        && this.getX() + 40 < e.getX() + 50
                                        && this.getY() + 50 > e.getY()
                                        && this.getY() + 50 < e.getY() + 40)//坦克左下角(x+40,y+50)
                            ) {
                                System.out.println("碰撞");
                                return true;
                            }
                        }
                    }
                }
                break;
            //左
            case 2:
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    EnemyTank e = enemyTankVector.get(i);
                    if (this != e) {
                        if (e.getDirection() == 0 || e.getDirection() == 1) {
                            if ((this.getX() - 10 > e.getX()
                                    && this.getX() - 10 < e.getX() + 40)
                                    && this.getY() > e.getY() - 10
                                    && this.getY() < e.getY() + 50//坦克左上角(x-10,y)
                                    || (this.getX() - 10 > e.getX()
                                        && this.getX() - 10 < e.getX() + 40
                                        && this.getY() + 40 > e.getY() - 10
                                        && this.getY() + 40 < e.getY() + 50)//坦克左下角(x-10,y+40)
                            ) {
                                System.out.println("碰撞");
                                return true;
                            }
                        }
                        if (e.getDirection() == 2 || e.getDirection() == 3) {
                            if ((this.getX() - 10 > e.getX() - 10
                                    && this.getX() - 10 < e.getX() + 50
                                    && this.getY() > e.getY()
                                    && this.getY() < e.getY() + 40)//坦克左上角(x-10,y)
                                    || (this.getX() - 10 > e.getX() - 10
                                        && this.getX() - 10 < e.getX() + 50
                                        && this.getY() + 40 > e.getY()
                                        && this.getY() + 40 < e.getY() + 40)//坦克左下角(x-10,y+40)
                            ) {
                                System.out.println("碰撞");
                                return true;
                            }
                        }
                    }
                }
                break;
            //右
            case 3:
                for (int i = 0; i < enemyTankVector.size(); i++) {
                    EnemyTank e = enemyTankVector.get(i);
                    if (e.getDirection() == 0 || e.getDirection() == 1) {
                        if ((this.getX() + 50 > e.getX()
                                && this.getX() + 50 < e.getX() + 40)
                                && this.getY() > e.getY() - 10
                                && this.getY() < e.getY() + 50//坦克右上角(x+50,y)
                                || (this.getX() + 50 > e.getX()
                                    && this.getX() + 50 < e.getX() + 40
                                    && this.getY() + 40 > e.getY() - 10
                                    && this.getY() + 40 < e.getY() + 50)//坦克右下角(x+50,y+40)
                        ) {
                            System.out.println("碰撞");
                            return true;
                        }
                    }
                    if (e.getDirection() == 2 || e.getDirection() == 3) {
                        if ((this.getX() + 50 > e.getX() - 10
                                && this.getX() + 50 < e.getX() + 50
                                && this.getY() > e.getY()
                                && this.getY() < e.getY() + 40)//坦克右上角(x+50,y)
                                || (this.getX() + 50 > e.getX() - 10
                                    && this.getX() + 50 < e.getX() + 50
                                    && this.getY() + 40 > e.getY()
                                    && this.getY() + 40 < e.getY() + 40)//坦克右下角(x+50,y+40)
                        ) {
                            System.out.println("碰撞");
                            return true;
                        }
                    }
                }
                break;
        }
        return false;
    }


    Vector<Bullet> enemybulletVector = new Vector<>();
    Bullet bullet = null;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //敌方坦克存活，且子弹数<3时才能进行射击
            if (isLive && enemybulletVector.size() < 3) {
                switch (getDirection()) {
                    case 0:
                        bullet = new Bullet(getX() + 20, getY() - 10, 0);
                        break;
                    case 1:
                        bullet = new Bullet(getX() + 20, getY() + 50, 1);
                        break;
                    case 2:
                        bullet = new Bullet(getX() - 10, getY() + 20, 2);
                        break;
                    case 3:
                        bullet = new Bullet(getX() + 50, getY() + 20, 3);
                        break;
                }
                enemybulletVector.add(bullet);
                new Thread(bullet).start();
            }
            //敌方坦克移动
            switch (getDirection()) {
                //1.先朝初始方向移动
                case 0:
                    //移动距离随机（30步以内）
                    for (int i = 0; i < (int) (Math.random() * 30); i++) {
                        if (!touch()) {
                            up();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < (int) (Math.random() * 30); i++) {
                        if (!touch()) {
                            down();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < (int) (Math.random() * 30); i++) {
                        if (!touch()) {
                            left();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < (int) (Math.random() * 30); i++) {
                        if (!touch()) {
                            right();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
//            //延迟，不让方向改变的那么突然
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //2.随机改变方向
            setDirection((int) (Math.random() * 4));
            if (isLive == false) {
                break;
            }
        }

    }

    //敌方坦克发射子弹
    public void enemyShot() {
        switch (getDirection()) {
            case 0:
                bullet = new Bullet(getX() + 20, getY() - 10, 0);
                break;
            case 1:
                bullet = new Bullet(getX() + 20, getY() + 50, 1);
                break;
            case 2:
                bullet = new Bullet(getX() - 10, getY() + 20, 2);
                break;
            case 3:
                bullet = new Bullet(getX() + 50, getY() + 20, 3);
                break;
        }
        enemybulletVector.add(bullet);
        new Thread(bullet).start();
    }


}
