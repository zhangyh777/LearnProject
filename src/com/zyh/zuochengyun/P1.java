package com.zyh.zuochengyun;

public class P1 {
    public static void main(String[] args) {


    }

    /**
     * 数组中只有一个数字出现了奇数次，别的数字都出现了偶数次，找出这个出现了奇数次的数
     *
     * @param nums
     * @return
     */
    public static int oneOdd(int[] nums) {
        /*
            异或操作
            把临时变量和数组中的所有数字依次异或,出现两次的数字异或之后变为0，0和任何数字异或结果都是该数字，最后的结果就是只出现奇数次的数
         */
        int eor = 0;
        for (int num : nums
        ) {
            eor = eor ^ num;
        }
        return eor;
    }

    /**
     * 数组中有两个数字出现了奇数次，别的数字都出现了偶数次，找出这两个出现了奇数次的数
     *
     * @param nums
     * @return
     */
    public static int[] twoOdd(int[] nums) {
        /*
            假设数组中只出现一次的两个数字是a和b
            1.临时变量temp和数组中的数字依次异或,最后的结果是数组中只出现一次的两个数字,即temp=a^b,且temp!=0
            2.因为temp!=0,所以temp得二进制里一定有1,找到最低位的1（即最右边的1）,假设在第l位,也就是说a和b两个数字的第l位肯定是一个为0,另一个为1
            3.数组可以分为两部分：第l位为1的,第l位为0的,a和b肯定是分别属于这两部分,
            4.新的临时变量1和第一部分的数字异或运算,得到一个结果
            5.新的临时变量2和第二部分的数字异或运算,得到另一个结果
         */
        int eor = 0;
        for (int num : nums
        ) {
            eor ^= num;
        }
        int rightOne = eor & (~eor + 1);
        int resOne = 0;
        int resTwo = 0;
        for (int num : nums
        ) {
            if ((num & rightOne) == 0) {//数组第一部分的数字
                resOne = resOne ^ num;
            } else {//数组第二部分的数字
                resTwo = resTwo ^ num;
            }
        }
        return new int[]{resOne, resTwo};
    }

    //位运算交换两个数字
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
