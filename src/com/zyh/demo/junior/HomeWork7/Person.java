package com.zyh.demo.junior.HomeWork7;

public class Person {
    private String name;
    private Vehicles vehicles;
    public Person(String name,Vehicles vehicles){
        this.name = name;
        this.vehicles = vehicles;
    }
//  一般情况下骑马
    public void common(){
//      如果初始交通工具不是Horse或者它的子类，就获取一匹马（VehiclesFactory里的静态成员）
        if(!(vehicles instanceof Horse)){
            vehicles =  VehiclesFactory.getHorse();
        }
        System.out.print("一般情况下");
        vehicles.work();
    }
//  过河时坐船
    public void river(){
//      如果初始交通工具不是船或者它的子类，就获取一艘船
        if(!(vehicles instanceof Boat)){
            vehicles = VehiclesFactory.getBoat();
        }
        System.out.print("过河时");
        vehicles.work();
    }
}
