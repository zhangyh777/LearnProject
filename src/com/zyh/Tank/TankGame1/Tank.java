package com.zyh.Tank.TankGame1;

public class Tank {
    private int x;
    private int y;
    private int speed = 2;
    private int direction;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public void up() {
        if (y - speed >= 0) {
            y -= speed;
        } else {
            System.out.println("越界");
        }
    }

    public void down() {
        if (y + speed <= 480) {
            y += speed;
        } else {
            System.out.println("越界");
        }
    }

    public void left() {
        if (x - speed >= 0) {
            x -= speed;
        } else {
            System.out.println("越界");
        }
    }

    public void right() {
        if (x + speed <= 1000) {
            x += speed;
        } else {
            System.out.println("越界");
        }
    }
}
