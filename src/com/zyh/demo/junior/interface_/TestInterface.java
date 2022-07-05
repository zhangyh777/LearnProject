package com.zyh.demo.junior.interface_;


public class TestInterface {
    public static void main(String[] args) {
//      创建设备
        Camera c =new Camera();
//      接口的多态性
//        1. 多态参数
//           接口类型的变量 可以指向任何实现了接口方法的对象实例
//        2. 多态数组（数组元素调用方法时，动态绑定）
//        3. 多态传递
        UsbInterface usb = new Phone();
        usb = new Camera();
        usb.stop();
        Phone p = new Phone();
//      创建计算机
        Computer computer = new Computer();
//      接入设备
        computer.work(p);
    }

}
