package com.zyh.demo.primary.extend_.exercise;

public class PC extends Computer{
    private String Brand;

    public PC(String CPU, int RAM, int disk, String brand) {
        super(CPU, RAM, disk);
        Brand = brand;
    }

    public void setBrand(String brand){
        this.Brand = brand;
    }
    public String getDetails(){
        String details = super.getDetails()+"Brand:"+Brand;
        return details;
    }
}
