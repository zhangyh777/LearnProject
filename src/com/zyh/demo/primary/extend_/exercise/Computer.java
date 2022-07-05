package com.zyh.demo.primary.extend_.exercise;

public class Computer {
    private String CPU;
    private int RAM;
    private int disk;

    public Computer(String CPU, int RAM, int disk) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.disk = disk;
    }
//  父类提供的公共方法来修改私有属性
    public void setCPU(String cpu){
        this.CPU = cpu;
    }

    public String getDetails(){
        return "CPU:"+CPU+"\tRAM:"+RAM+"\tDisk"+disk+"\t";
    }
}
