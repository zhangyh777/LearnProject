package com.zyh.Tank.TankGame2;

/**
 *
 * 1.发射一颗子弹相当于启动一个线程
 * 2.我方坦克要有子弹对象才能发射子弹
 * 3.画布需要不停重绘子弹，显示动态射击效果
 * 4.子弹碰到边界或者敌方坦克时，销毁（终止线程）
 */
public class Bullet implements Runnable{
    //子弹位置，方向
    public int x;
    public int y;
    public int direction;
    //子弹速度，大于坦克速度
    public int speed = 5;
    //子弹存活标志
    public boolean isLive = true;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direction){
                case 0:
                    y-=speed;
                    break;
                case 1:
                    y+=speed;
                    break;
                case 2:
                    x-=speed;
                    break;
                case 3:
                    x+=speed;
                    break;
            }
            //子弹越界或者击中敌方坦克
            if(!((x>=0&&x<=720&&y>=0&&y<=480)&&isLive)){
                isLive = false;
                break;
            }
        }
    }

}
