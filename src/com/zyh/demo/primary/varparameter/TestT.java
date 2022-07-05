package com.zyh.demo.primary.varparameter;

public class TestT {
    public static void main(String[] args){
    Method m = new Method();
    System.out.println(m.showScore("zyh",90,86.6,67.5));
    }
}
class Method{
    Method(){}
//  可变长参数
    public String showScore(String name,double...score){
        double res = 0;
        for(int i=0;i<score.length;i++){
            res+=score[i];
        }
        return name+" "+score.length+"门课总分:"+res;
    }
}