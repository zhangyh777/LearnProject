package com.zyh.Tank.TankGame1;

import javax.swing.*;

/**
 * 1.坦克属性
 *      坐标-(x,y),方向-direction,速度-speed
 *   敌我坦克颜色不同
 * 2.绘制我方坦克
 * 3.绘制敌方坦克
 *   3.1 敌方坦克数量多，每辆坦克又都有各自的特性，要求线程安全，用Vector存储
 *   3.2 敌方坦克初始方向随机
 * 4.键盘控制我方坦克移动
 *   4.1 引入键盘事件，画布监听键盘事件
 *   4.2 坦克移动范围限制
 *   坦克移动后要进行重绘
 */
public class TankGame extends JFrame {
    //定义一个画布
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }
    //画框构造器
    public TankGame(){
        //初始化画布
        mp = new MyPanel();
        //画布放到画框里面
        this.add(mp);
        //监听键盘事件
        this.addKeyListener(mp);
        //画框大小（和画布是不同的两个东西）
        this.setSize(750,500);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
