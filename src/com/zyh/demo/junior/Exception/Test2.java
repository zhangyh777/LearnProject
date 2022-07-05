package com.zyh.demo.junior.Exception;

public class Test2 {
    public static int method(){
        int i = 1;
        try{
            i++;//i=2
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
            return ++i;//i=3
        }finally {
//          return i++;//i=3
            return ++i;//i=4
        }
    }
    public static void main(String[] args) {
        System.out.println(method());
    }
}
