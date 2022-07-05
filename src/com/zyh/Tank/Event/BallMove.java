package com.zyh.Tank.Event;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * java事件处理机制 -> ”委派事件模型“
 * 当事件发生时，产生事件的对象，会把“信息”传递给“事件的监听者”处理
 */
public class BallMove extends JFrame {
    MyPanel myPanel = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove(){
        myPanel = new MyPanel();
        this.add(myPanel);

//      MyPanel可以监视键盘事件
        this.addKeyListener(myPanel);

        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
//KeyListener键盘监视器
class MyPanel extends JPanel implements KeyListener {
    int x = 1;
    int y = 1;
    @Override
    public void paint(Graphics g){
//      坐标(x,y),初始坐标为(10,10)
        super.paint(g);
        g.fillOval(x,y,10,10);
    }
//  重写实现KeyListener的方法
//  1.有字符输出时触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
//  2.按键按下时触发
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                if(y<0){
                    System.out.println("出界！");
                }else{
                    y--;
                }

                break;
            case KeyEvent.VK_DOWN:
                if(y>400){
                    System.out.println("出界！");
                }
                else{
                    y++;
                }

                break;
            case KeyEvent.VK_LEFT:
                if(x<0){
                    System.out.println("出界！");
                }
                else{
                    x--;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(x>400){
                    System.out.println("出界！");
                }
                else{
                    x++;
                }

                break;
            default:
                System.out.println("操作错误,使用↑↓←→按键");
                break;
        }
        this.repaint();

    }
//  3.按键松开时触发
    @Override
    public void keyReleased(KeyEvent e) {

    }


}
