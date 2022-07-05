package com.zyh.Tank.TankGame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;


public class MyPanel extends JPanel implements KeyListener, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //我方子弹不为空且存活，就遍历敌方坦克，判断我方子弹是否击中敌方坦克
            for (int i = 0; i < myTank.myBullet.size(); i++) {
                Bullet bullet = myTank.myBullet.get(i);
                if (bullet != null && bullet.isLive) {
                    for (int k = 0; k < enemyTankVector.size(); k++) {
                        EnemyTank enemy = enemyTankVector.get(k);
                        hitTank(myTank.myBullet, enemy);

                    }
                }
            }
            //敌方坦克的子弹是否击中我方
            for (int i = 0; i < enemyTankVector.size(); i++) {
                EnemyTank e = enemyTankVector.get(i);
                hitTank(e.enemybulletVector, myTank);
            }

            //画布每隔100ms重绘一次，调用repaint方法会自动调用paint方法
            this.repaint();
        }
    }

    //存放炸弹的集合
    Vector<Bomb> Bombs = new Vector<>();
    //三张火花不同的图片来回切换动态展示爆炸火花
    Image img1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/1.png"));
    Image img2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/2.png"));
    Image img3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/3.png"));

    //定义我方坦克
    MyTank myTank = null;
    //定义Vector<EnemyTank>存放敌方坦克
    Vector<EnemyTank> enemyTankVector = new Vector<>(10);
    //存放残局坦克信息
    Vector<Node> nodes = new Vector<>();
    //画布构造器
    public MyPanel(String key) {
        //初始化自己的坦克
        myTank = new MyTank(100, 100);

        Recorder.setEnemyTanks(enemyTankVector);
        File file = new File(Recorder.getFilePath());
        //存档文件是否存在
        if(file.exists()){
            nodes = Recorder.getInfo();
        }else{
            System.out.println("存档文件不存在，开启新游戏");
            key = "1";
        }

        switch(key){
            case "1"://新游戏
                //初始化敌方坦克,位置随机(但都在画布里),存放到Vector里
                for (int i = 0; i < enemyTankVector.capacity(); i++) {
                    EnemyTank e = new EnemyTank((int) (Math.random() * 680), (int) (Math.random() * 440));
                    e.setEnemyTankVector(enemyTankVector);
                    enemyTankVector.add(e);
                    //方向随机
                    e.setDirection((int) (Math.random() * 4));
                    new Thread(e).start();
                }
                break;
            case "2"://继续上次游戏

                //读取存档信息,恢复坦克位置(x,y,direction)
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    EnemyTank e = new EnemyTank(node.getX(),node.getY());
                    e.setEnemyTankVector(enemyTankVector);
                    enemyTankVector.add(e);
                    e.setDirection(node.getDirection());
                    new Thread(e).start();
                }
                break;
            default:
                System.out.println("输入错误");
        }

    }

    //(多发)子弹是否击中坦克
    public void hitTank(Vector<Bullet> bulletVector, Tank t){
        for (int i = 0; i < bulletVector.size(); i++) {
            Bullet b = bulletVector.get(i);
            if (t.isLive) {//坦克存活时才进行击中与否的判断
                if (b.x > t.getX() && b.x < t.getX() + 40
                        && b.y > t.getY() && b.y < t.getY() + 40) {//击中
                    b.isLive = false;//子弹消亡
                    t.isLive = false;//坦克消亡
                    Bombs.add(new Bomb(t.getX(), t.getY()));
                    //如果被击毁的坦克是敌方坦克
                    if(t instanceof EnemyTank){
                        //从敌方坦克集合里抹去被击杀的坦克
                        enemyTankVector.remove(t);
                        //杀敌数+1
                        Recorder.addKillNum();
                        Recorder.save();
                    }
                    //如果被击毁的是我方坦克
                    if(t instanceof MyTank){
                        System.out.println("我方坦克被击毁");
                    }

                }
            }

        }

    }
    //信息面板
    public void showinfo(Graphics g){
        g.setColor(Color.BLACK);
        Font font = new Font("宋体",Font.BOLD,25);
        g.setFont(font);
        g.drawString("杀敌数",780,30);
        drawTank(720,50,g,0,1);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllKillEnemy()+"",800,80);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充画布背景
        g.fillRect(0, 0, 720, 480);
        //
        showinfo(g);

        //绘制我方坦克(非空且存活才绘制)
        if(myTank!=null&&myTank.isLive){
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirection(), 0);
        }


        //绘制我方坦克子弹
        for (int i = 0; i < myTank.myBullet.size(); i++) {
            Bullet bullet = myTank.myBullet.get(i);
            if (bullet != null && bullet.isLive) {
                g.fill3DRect(bullet.x, bullet.y, 2, 2, false);
            } else {
                myTank.myBullet.remove(bullet);
            }
        }

        //遍历enemyTankVector绘制敌方坦克
        for (int i = 0; i < enemyTankVector.size(); i++) {
            //敌方坦克
            EnemyTank e = enemyTankVector.get(i);

            if (e.isLive) {//坦克存活时进行绘制
                drawTank(e.getX(), e.getY(), g, e.getDirection(), 1);
            }

            //绘制每辆敌方坦克的子弹
            for (int j = 0; j < e.enemybulletVector.size(); j++) {
                Bullet b = e.enemybulletVector.get(j);
                if (b.isLive) {
                    g.fill3DRect(b.x, b.y, 2, 2, false);
                } else {
                    e.enemybulletVector.remove(b);
                }
            }

            //绘制炸弹
            for (int j = 0; j < Bombs.size(); j++) {
                Bomb b = Bombs.get(j);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (b.life > 6) {
                    g.drawImage(img1, b.x, b.y, 40, 40, this);
                } else if (b.life > 3) {
                    g.drawImage(img2, b.x, b.y, 40, 40, this);
                } else {
                    g.drawImage(img3, b.x, b.y, 40, 40, this);
                }
                b.lifeDown();
                if (b.life == 0) {
                    Bombs.remove(b);
                }
            }
        }
    }


    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        //根据坦克阵营绘制坦克
        switch (type) {
            //我方坦克,绿色
            case 0:
                g.setColor(Color.GREEN);
                break;
            //敌方坦克,黄色
            case 1:
                g.setColor(Color.ORANGE);
                break;

        }
        //根据坦克方向绘制坦克
        switch (direction) {
            //上
            case 0:
                //左轮(x,y,10,40)
                g.fill3DRect(x, y, 10, 40, false);
                //右轮(x+30,y,10,40)
                g.fill3DRect(x + 30, y, 10, 40, false);
                //车身(x+10,y+10,20,20)
                g.fill3DRect(x + 10, y + 10, 20, 20, false);
                //舱门（车身内接圆形）(x+10,y+10,20,20)
                g.fillOval(x + 10, y + 10, 20, 20);
                //枪管(起点在舱门中心)（x+20,y+20,x,y-10）
                g.drawLine(x + 20, y + 20, x + 20, y - 10);
                break;
            //下
            case 1:
                //左轮(x,y,10,40)
                g.fill3DRect(x, y, 10, 40, false);
                //右轮(x+30,y,10,40)
                g.fill3DRect(x + 30, y, 10, 40, false);
                //车身(x+10,y+10,20,20)
                g.fill3DRect(x + 10, y + 10, 20, 20, false);
                //舱门（车身内接圆形）(x+10,y+10,20,20)
                g.fillOval(x + 10, y + 10, 20, 20);
                //枪管(起点在舱门中心)（x+20,y+20,x,y+50）
                g.drawLine(x + 20, y + 20, x + 20, y + 50);
                break;
            //左
            case 2:
                //上轮
                g.fill3DRect(x, y, 40, 10, false);
                //下轮
                g.fill3DRect(x, y + 30, 40, 10, false);
                //车身
                g.fill3DRect(x + 10, y + 10, 20, 20, false);
                //舱门
                g.fillOval(x + 10, y + 10, 20, 20);
                //枪口
                g.drawLine(x + 20, y + 20, x - 10, y + 20);
                break;
            //右
            case 3:
                //上轮
                g.fill3DRect(x, y, 40, 10, false);
                //下轮
                g.fill3DRect(x, y + 30, 40, 10, false);
                //车身
                g.fill3DRect(x + 10, y + 10, 20, 20, false);
                //舱门
                g.fillOval(x + 10, y + 10, 20, 20);
                //枪口
                g.drawLine(x + 20, y + 20, x + 50, y + 20);
                break;
        }

    }

    //↑↓←→控制坦克移动，J发射子弹
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            myTank.setDirection(0);
            myTank.up();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            myTank.setDirection(1);
            myTank.down();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            myTank.setDirection(2);
            myTank.left();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            myTank.setDirection(3);
            myTank.right();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {

            myTank.shotEnemy();
        }

        this.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
