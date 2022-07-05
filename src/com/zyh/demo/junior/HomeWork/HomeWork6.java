package com.zyh.demo.junior.HomeWork;

/**
 * 1.交通工具接口Vehicles，work功能
 * 2.Horse类和Boat类实现Vehicles接口
 * 3.创建交通工具工厂类VehiclesFactory，有两个方法分别获得Horse和Boat
 * 4.Perosn类，私有属性name和vehicle，有参构造器
 * 5.实例化Person对象”唐僧“，交通工具：一般情况下用Horse，过河的时候用Boat
 * 6.扩展：过火焰山使用飞机
 */
public class HomeWork6 {
    public static void main(String[] args) {
        Person person = new Person("唐僧",new Horse());
        person.passRiver();
        person.common();
        person.passRiver();
        person.common();
        person.passRiver();
        person.passRiver();
        person.fire();



    }
}
interface Vehicles{
    public abstract void work();
}
class Horse implements Vehicles{

    @Override
    public void work(){
        System.out.print("骑马"+"\n");
    }
}
class Boat implements Vehicles{
    @Override
    public void work(){
        System.out.print("坐船"+"\n");
    }
}
class Helicopter implements Vehicles{
    @Override
    public void work(){
        System.out.println("坐飞机"+"\n");
    }
}
class VehiclesFactory{
//  马不会换
    public static Horse horse = new Horse();
    public static Horse getHorse(){
        return horse;
    }
//  船会换
    public static Boat getBoat(){
        return new Boat();
    }
//
    public static Helicopter getHelicopter(){
        return new Helicopter();
    }
}
class Person{
    private String name;
    private Vehicles vehicle;

    public Person(String name, Vehicles vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }
    public void common(){
//      如果交通工具不是Horse(null或则Boat)
        if(!(vehicle instanceof Horse)){
            vehicle= VehiclesFactory.getHorse();
        }
        System.out.print("过路时");
        vehicle.work();
    }
    public void passRiver(){
//      如果交通工具不是Boat(null或者Horse)
        if(!(vehicle instanceof Boat)){
            vehicle = VehiclesFactory.getBoat();
        }
        System.out.print("过河时");
        vehicle.work();
    }
    public void fire(){
        if(!(vehicle instanceof Helicopter)){
            vehicle = VehiclesFactory.getHelicopter();
        }
        System.out.print("过火焰山时");
        vehicle.work();
    }
}