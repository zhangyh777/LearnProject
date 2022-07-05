package com.zyh.demo.junior.HomeWork;

public class HomeWork8 {
    public static void main(String[] args) {
        Color red = Color.RED;
        red.show();
        switch (red){
            case RED:
                System.out.println("匹配到红色");
                break;
            case YELLOW:
                System.out.println("匹配到黄色");
                break;
            case BLACK:
                System.out.println("匹配到黑色");
                break;
        }

    }
}
enum Color implements IA{
    RED(255,0,0),
    BULE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }
    @Override
    public void show(){
        System.out.println("redValue:"+redValue+"\t"
                            +"greenValue:"+greenValue+"\t"
                            +"bluedValue:"+blueValue);


    }
}
interface IA{
    public abstract void show();
}