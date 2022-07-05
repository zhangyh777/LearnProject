package com.zyh.demo.junior.HomeWork7;

public class VehiclesFactory {
//  静态Horse类对象horse
    private static Horse horse = new Horse();
//  构造器私有化，不让外部类新建对象进而调用get方法新建交通工具
    private VehiclesFactory(){}
    public static Horse getHorse(){
        return horse;
    }
    public static Boat getBoat(){
        return new Boat();
    }



}
