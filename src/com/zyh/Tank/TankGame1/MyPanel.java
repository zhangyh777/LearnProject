package com.zyh.Tank.TankGame1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    //定义我方坦克
    MyTank myTank = null;
    //定义Vector<EnemyTank>存放敌方坦克
    Vector<EnemyTank> enemyTankVector = new Vector<>(3);

    //画布构造器
    public MyPanel() {
        //初始化自己的坦克
        myTank = new MyTank(100,100);

        //初始化敌方坦克,位置随机(都在画布里),放到Vector里
        for (int i = 0; i < enemyTankVector.capacity(); i++) {

            enemyTankVector.add(i,new EnemyTank((int)(Math.random()*680),(int)(Math.random()*440)));
            //方向随机
            enemyTankVector.get(i).setDirection((int)(Math.random()*4));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充画布背景
        g.fillRect(0,0,720,480);

        //绘制我方坦克
        drawTank(myTank.getX(), myTank.getY(), g,myTank.getDirection(),0);

        //遍历enemyTankVector绘制敌方坦克
        for (int i = 0; i < enemyTankVector.size(); i++) {
            EnemyTank e = enemyTankVector.get(i);
            drawTank(e.getX(),e.getY(),g,e.getDirection(),1);
        }

    }
    public void drawTank(int x,int y,Graphics g,int direction,int type){
        //根据坦克阵营绘制坦克
        switch(type){
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
        switch(direction){
            //上
            case 0:
                //左轮(x,y,10,40)
                g.fill3DRect(x,y,10,40,false);
                //右轮(x+30,y,10,40)
                g.fill3DRect(x+30,y,10,40,false);
                //车身(x+10,y+10,20,20)
                g.fill3DRect(x+10,y+10,20,20,false);
                //舱门（车身内接圆形）(x+10,y+10,20,20)
                g.fillOval(x+10,y+10,20,20);
                //枪管(起点在舱门中心)（x+20,y+20,x,y-10）
                g.drawLine(x+20,y+20,x+20,y-10);
                break;
            //下
            case 1:
                //左轮(x,y,10,40)
                g.fill3DRect(x,y,10,40,false);
                //右轮(x+30,y,10,40)
                g.fill3DRect(x+30,y,10,40,false);
                //车身(x+10,y+10,20,20)
                g.fill3DRect(x+10,y+10,20,20,false);
                //舱门（车身内接圆形）(x+10,y+10,20,20)
                g.fillOval(x+10,y+10,20,20);
                //枪管(起点在舱门中心)（x+20,y+20,x,y+50）
                g.drawLine(x+20,y+20,x+20,y+50);
                break;
            //左
            case 2:
                //上轮
                g.fill3DRect(x,y,40,10,false);
                //下轮
                g.fill3DRect(x,y+30,40,10,false);
                //车身
                g.fill3DRect(x+10,y+10,20,20,false);
                //舱门
                g.fillOval(x+10,y+10,20,20);
                //枪口
                g.drawLine(x+20,y+20,x-10,y+20);
                break;
            //右
            case 3:
                //上轮
                g.fill3DRect(x,y,40,10,false);
                //下轮
                g.fill3DRect(x,y+30,40,10,false);
                //车身
                g.fill3DRect(x+10,y+10,20,20,false);
                //舱门
                g.fillOval(x+10,y+10,20,20);
                //枪口
                g.drawLine(x+20,y+20,x+50,y+20);
                break;
        }

    }

    //控制坦克移动
    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                myTank.setDirection(0);
                myTank.up();
                break;
            case KeyEvent.VK_DOWN:
                myTank.setDirection(1);
                myTank.down();
                break;
            case KeyEvent.VK_LEFT:
                myTank.setDirection(2);
                myTank.left();
                break;
            case KeyEvent.VK_RIGHT:
                myTank.setDirection(3);
                myTank.right();
                break;
            default:
                System.out.println("操作错误");
        }
        this.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

}
