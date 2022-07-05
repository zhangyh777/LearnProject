package com.zyh.demo.junior.Exception;

/**
 * throws 和 throw
 */
public class SelfDefinedException {
    public static void main(String[] args) {
        int age = 180;

        if(age<=0||age>100){
            throw new AgeException("年龄不对，要在[0,100]之间");
        }
        System.out.println("年龄正常");
    }
}
class AgeException extends RuntimeException{
    public AgeException(String message){
        super(message);
    }
}
