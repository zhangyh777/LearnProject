package com.zyh.demo.junior.Exception;

public class Exception {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        int res = 0;
        try {//可能发生异常的代码块
             //异常发生之后，异常语句后面的语句不会再执行
             //没有异常发生的话，执行完try之后不会进入catch
            res = num1/num2;
            System.out.println("异常发生");
        } catch (java.lang.Exception e) {
            //捕获异常
            //1.捕获到异常
            //2.系统将异常封装成Exception对象e，传递给catch
            //3.得到异常对象后，程序员自己做相应的处理
            //4.如果没有异常发生，catch语句不执行
            System.out.println("异常原因："+e.getMessage());
        }finally{//不管try代码是否有异常发生，都要执行finally语句（也可以不要finally语句）
                 //通常将释放资源的语句放到finally语句
            System.out.println("执行finally语句");
        }
        System.out.println("程序继续走");
    }
}

