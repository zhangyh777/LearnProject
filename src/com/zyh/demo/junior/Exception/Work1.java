package com.zyh.demo.junior.Exception;

/**
 * 编写程序Work1.java，接受命令行的两个参数（整数），计算两数相除
 * 计算两数相除，要求使用方法cal(int n1,int n2)
 * 对输入数据格式不正确，缺少命令行参数，除数为0的异常进行处理
 */
public class Work1 {
    public static void main(String[] args) {

        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            double res = cal(n1, n2);
            System.out.println(n1 + "/" + n2 + "=" + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("出现了除数为0的错误情况");
        } catch (NumberFormatException e){
            System.out.println("输入数据格式不正确");
        }


    }

    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}

