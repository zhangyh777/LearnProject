package com.zyh.Tank.TankGame2;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * 5.坦克发射子弹（线程）
 *   5.1 我方坦克发射子弹（单发子弹）
 *      5.1.1 我方坦克具有子弹类对象，才能发射子弹
 *      5.1.2 子弹发射方向是朝着坦克方向的，子弹速度大于坦克速度
 *      5.1.3 射击行为是键盘事件，由MyPanel监视，每按下J就发射一发子弹（启动线程）
 *      5.1.4 子弹射出后位置发生变化，要进行重绘
 *   5.2 敌方坦克发射子弹（可以有多颗子弹）
 *      5.2.1
 *   6.障碍物
 *      墙壁，生命值为1，墙壁存在时坦克不能穿过，子弹射击到之后墙壁销毁
 *      钢板，生命值为2，钢板存在时坦克不能穿过，子弹射击到之后钢板生命值-1
 *      水域，坦克不能下水，子弹可以打过去且不会消失
 *
 */
public class TankGame extends JFrame {
    Scanner myScan = new Scanner(System.in);
    //定义一个画布
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }

    //画框构造器
    public TankGame(){
        System.out.println("输入选项  1.新游戏  2.继续上次游戏");
        String key = myScan.next();
        //初始化画布
        mp = new MyPanel(key);
        //画布放到画框里面
        this.add(mp);
        //监听键盘事件
        this.addKeyListener(mp);
        //监听窗口事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭游戏");
                Recorder.save();
                System.exit(0);
            }
        });
        new Thread(mp).start();
        //画框大小（和画布是不同的两个东西）
        this.setSize(900,500);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
