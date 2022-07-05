package com.zyh.demo.primary.test;

public class Test09 {
    public static void main(String[] args){
        Music m1 = new Music("Five Hundred Miles","03:26");
        m1.play();
        String info = m1.getInfo();
        System.out.print(info);
    }
}
class Music{
    String name;
    String times;
    public Music(String name,String times){
        this.name = name;
        this.times = times;
    }
    public void play(){
        System.out.println("开始播放:"+this.name);
    }
    public String getInfo(){
        return "name:"+name+"\n"+"times:"+times;
    }
}
