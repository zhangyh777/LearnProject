package com.zyh.demo.junior.interface_;

public class Camera implements UsbInterface{
    @Override
    public void start(){
        System.out.println("相机连接成功");
    }
    @Override
    public void stop(){
        System.out.println("相机断开连接");
    }
}
