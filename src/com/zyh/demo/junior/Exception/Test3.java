package com.zyh.demo.junior.Exception;

public class Test3 {
    public static int method(){
        int i = 1;
        try{
            i++;//2
            String[] names = new String[3];
            if(names[1].equals("tom")){//NullPointerException
                System.out.println(names[1]);
            }else{
                names[3]="hspedu";
            }
            return 1;
        }catch(ArrayIndexOutOfBoundsException e){
            return 2;
        }catch(NullPointerException e){
            return ++i;//3
        }finally {
            ++i;//4
            System.out.println("i=" + i);
        }
    }
    public static void main(String[] args) {
        System.out.println(method());
    }
}
