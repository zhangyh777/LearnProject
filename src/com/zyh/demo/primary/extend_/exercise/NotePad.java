package com.zyh.demo.primary.extend_.exercise;

public class NotePad extends Computer{
//  子类特有的属性
    private String color;

    public NotePad(String CPU, int RAM, int disk, String color) {
//      继承父类的 CPU,RAM,disk 属性
        super(CPU, RAM, disk);
        this.color = color;
    }
//  子类特有的方法
    public void setColor(String color) {
        this.color = color;
    }
//  super.父类方法，调用父类的方法，
    public String getDetails(){
        String details = super.getDetails()+"Color:"+color;
        return details;
    }
}
