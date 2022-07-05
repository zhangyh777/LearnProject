package com.zyh.demo.junior.HomeWork;

public class HomeWork7 {
    public static void main(String[] args) {
        Car.Air air1 = new Car(41).new Air();
        air1.flow();
        Car.Air air2 = new Car(-5).new Air();
        air2.flow();
    }
}
class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }
//  成员内部类
    class Air{

        public void flow(){
            if(temperature>40){
                System.out.println("温度"+temperature+"℃,"+"吹冷风");
            }else if(temperature<0){
                System.out.println("温度"+temperature+"℃,"+"吹热风");
            }else{
                System.out.println("温度"+temperature+"℃,"+"关闭空调");
            }
        }
    }
}



