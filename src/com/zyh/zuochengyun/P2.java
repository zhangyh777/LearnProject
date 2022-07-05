package com.zyh.zuochengyun;

public class P2 {
    /**
     * 归并排序的拓展
     * 1.小和问题
     * 2.逆序对问题
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(reversePairs(nums));
    }

    /**
     * <p>
     * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和
     * </p>
     * <p>
     * [1,3,4,2,5] 1左边比1小的数没有；3左边比3小的数有1，4左边有1,3；2左边有1；5左边有1，3,4,2。所以这个数组的小和为1+1+3+1+1+3+4+2=16
     * </p>
     *
     * @return
     */
    public static int smallSum(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) >> 1;
        return smallSum(nums, left, mid) + smallSum(nums, mid + 1, right) + merge(nums, left, right);
    }

    public static int merge(int[] nums, int left, int right) {
        int mid = left + (right - left) >> 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        //遍历左半部数组的指针
        int tempLeft = left;
        //遍历右半部数组的指针
        int tempRight = mid + 1;
        //小和
        int count = 0;

        /*
            每个数左边比它小的数加起来,相当于找每个数右边有多少个比它大的数,
            假设数字a右边有n个比a大的数,那么在计算小和的时候,a就会出现n次,每个数都是同样的道理
            [1,3,4,2,5]
            1右边有4个比1大的数,1*4
            3右边有2个比3大的数,2*3
            4右边有1个比4大的数,1*4
            2右边有1个比2大的数,1*2
            1*4+2*3+1*4+1*2=16
         */
        //左右两部分数组都还没遍历完
        while (tempLeft <= mid && tempRight <= right) {
            //小和
            //只有左边的数比右边的数小的时候小和才发生变化
            count += nums[tempLeft] < nums[tempRight] ? nums[tempLeft] * (right - left + 1) : 0;
            //临时数组
            temp[index++] = nums[tempLeft] < nums[tempRight] ? nums[tempLeft++] : nums[tempRight++];
        }
        //左数组还没遍历完
        while (tempLeft <= mid) {
            temp[index++] = nums[tempLeft++];
        }
        //右数组还没遍历完
        while (tempRight <= right) {
            temp[index++] = nums[tempRight++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }

        return count;

    }


    /**
     * <p>
     * 逆序对问题
     * </p>
     * <p>
     * 一个数组中,如果左边的数比右边的数大,那么这两个数字构成一个逆序对,求出数组有多少个逆序对
     * </p>
     *
     * @return
     */
    public static int reversePairs(int[] nums) {
        if (nums.length < 2)
            return 0;
        return MergeSort(nums, 0, nums.length - 1);
    }

    public static int MergeSort(int[] nums, int left, int right) {
        if (left == right)
            return 0;
        int mid = left + ((right - left) >> 1);
        //左边逆序对加右边部分产生的逆序对再加merge过程产生的逆序对为最终的数量
        return MergeSort(nums, left, mid)
                +MergeSort(nums, mid + 1, right)
                +Merge(nums, left, mid, right);
    }

    public static int Merge(int[] nums, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int index = 0;

        int tempLeft = left;
        int tempRight = mid + 1;

        int count = 0;

        while (tempLeft <= mid && tempRight <= right) {
            //逆序对的数量
            //左右两半部分都是有序的了
            //如果左边遍历到的数字x比右边遍历到的数字y大的话
            // ,说明在左半部分,x右边的数字都是比y大的
            // ,在左半部分,从tempLeft开始到mid结束,这些数字都能和y构成逆序对
            // ,count+=mid+1-tempLeft
            //如果左边遍历到的数字x不比右边遍历到的数字y大的话,就说明x不能和y构成逆序对,count+=0
            count += nums[tempLeft] > nums[tempRight] ? (mid - tempLeft + 1) : 0;
            tempArr[index++] = nums[tempLeft] > nums[tempRight] ? nums[tempLeft++] : nums[tempRight++];
        }
        while (tempLeft <= mid) {
            tempArr[index++] = nums[tempLeft++];
        }
        while (tempRight <= right) {
            tempArr[index++] = nums[tempRight++];
        }
        for (int j = 0; j < tempArr.length; j++) {
            nums[left + j] = tempArr[j];
        }
        return count;
    }

    /**
     * 快速排序
     * @param nums
     */
    public static void quickSort(int[] nums){

    }

}
