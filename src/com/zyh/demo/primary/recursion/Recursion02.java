package com.zyh.demo.primary.recursion;

//斐波那契数列
public class Recursion02 {
    public static void main(String[] args){
        C c = new C();
        int fibNum = c.fib(8);
        System.out.println(fibNum);

        int peach = c.monkyPeach(1);
        System.out.println(peach);
    }
}
class C{
//  斐波那契
    public int fib(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return fib(n-2)+fib(n-1);
        }
    }
//  猴子吃桃
//  每天吃一半多一个....,第10天只剩一个桃子(还没吃),一共多少个桃子？
//  思路：逆推
//       第10天还没吃，那么第9天剩下的就是第10天剩下的，第9天剩下一个：n/2-1=1,第9天原本有4个桃子，吃3个
//       往前推，前一天的桃子=(后一天的桃子+1)*2
//       10天：1个
//       9天：（1+1）*2=4
//       8天：（4+1）*2=10
//       .....
    public int monkyPeach(int day){
        if(day==10){
            return 1;
        }else if(day>=1&&day<=9){
            return (monkyPeach(day+1)+1)*2;
        }else{
            System.out.println("day在[1,10]");
            return 1224;
        }


    }
}
