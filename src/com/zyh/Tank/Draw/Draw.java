package com.zyh.Tank.Draw;

import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame{
//  定义一个画布
    private mPanel mp = null;
    public static void main(String[] args) {
        new Draw();

    }
//  画框构造器
    public Draw(){
        //画布对象
        mp = new mPanel();
        //画布放到画框里面
        this.add(mp);
//      设置画框大小
        this.setSize(400,300);
//      x掉窗口时就关闭程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      可见性
        this.setVisible(true);

    }
}
//画布，继承JPanel
class mPanel extends JPanel{
    /*
    1.MyPanel对象 就是画布
    2.Graphics g 就是画笔
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);

        //paint方法被调用的情况
        //1.组件第一次在屏幕显示时
        //2.窗口大小发生变化时
        //3.repaint方法被调用时
        /*
            1.直线,drawLine(x1,y1,x2,y2)
            2.矩形边框,drawRect(x,y,width,height)
            3.(椭)圆边框(矩形内接圆),drawOval(x,y,width,height)
            4.填充矩形,fillRect(x,y,width,height)
            5.填充椭圆,fillOval(x,y,width,height)
            6.画图片,drawImage(Image img,x,y,..)
            7.画字符串,drawString(String str,x,y)
            9.设置笔画字体,setFont(Font font)
            10.设置笔画颜色,setColor(Color c)

         */
        System.out.println("paint方法被调用");
        g.setColor(Color.GREEN);
//      左轮,(50,50),w10,h50
        g.fill3DRect(50,50,10,40,false);
//      车身,(x+10,y+10),w30,h30
        g.fill3DRect(60,60,20,20,false);
//      右轮,(x+10+30,y),w10,h50
        g.fill3DRect(80,50,10,40,false);
//      圆形舱门,车身的内接圆,(60,60),w20,h20
        g.fillOval(60,60,20,20);
//      枪管,
        g.drawLine(70,70,70,40);


//       设置画笔颜色
//        g.setColor(Color.GREEN);

////      (x1,y1)起点坐标,(x2,y2)终点坐标
//        g.drawLine(10,10,50,10);

////      (x,y)矩形左上角点的坐标,width宽,height高
//        g.drawRect(20,20,50,50);
//        g.fillRect(200,200,10,10);
//        g.drawOval(100,100,100,10);
//        g.fillOval(80,80,10,10);
//        读取图片地址
//        Image img = Toolkit.getDefaultToolkit().getImage(mPanel.class.getResource("/1.png"));
//        绘制
//        g.drawImage(img,0,0,60,60,this);

    }
}
