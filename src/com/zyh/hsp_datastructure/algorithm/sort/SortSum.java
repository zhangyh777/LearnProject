package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

public class SortSum {
    public static void main(String[] args) {
        int[] array1 = {1, 4, 6, 9, 10, 2, 3, 5, 8, 7};
        System.out.println(Arrays.toString(insert(array1)));


    }

    //冒泡排序
    //N个数参与冒泡排序，一共进行N-1轮排序，每轮(第i轮)再进行N-i次排序
    //从小到大冒泡的话
    //,第一轮找出最大的数放到最后
    //,第二轮相比第一轮少遍历1次（没有遍历第一轮找出的最大的数），找出该轮最大的数（所有数里第二大的数）放到该轮最后的位置（整个数组倒数第二个位置）,该数字不再参与后续冒泡
    //,......
    public static int[] bubble(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //swap(array,j,j+1);
                    int temp = array[j];//大数暂存temp
                    array[j] = array[j + 1];//小数放到前面
                    array[j + 1] = temp;//大数放到后面
                }
            }
//            System.out.printf("第%d轮冒泡结果：", i + 1);
//            System.out.println(Arrays.toString(array));
        }

//        //第一轮
//        for (int i = 0; i < 4-1; i++) {
//            if(array[i]>array[i+1]){//
//                int temp = array[i];//大数暂存temp
//                array[i] = array[i+1];//小数放到前面
//                array[i+1] = temp;//大数放到后面
//            }
//        }
//        System.out.println("第1轮冒泡排序结果：");
//        System.out.println(Arrays.toString(array));
//        //第二轮
//        for (int i = 0; i < 4-2; i++) {
//            if(array[i]>array[i+1]){
//                int temp = array[i];
//                array[i] = array[i+1];
//                array[i+1] = temp;
//            }
//        }
//        System.out.println("第2轮冒泡排序结果：");
//        System.out.println(Arrays.toString(array));
//        //第三轮
//        for (int i = 0; i < 4-3; i++) {
//            if(array[i]>array[i+1]){
//                int temp = array[i];
//                array[i] = array[i+1];
//                array[i+1] = temp;
//            }
//        }
//        System.out.println("第3轮冒泡排序结果：");
//        System.out.println(Arrays.toString(array));
        return array;
    }

    //选择排序
    //N个数参与选择排序，进行N-1轮，第i轮从N-i个数里面找出最小的数
    //每轮第一个数看作是最小的数，在后面的所有数里面找到更小的和该数交换
    //......
    public static int[] select(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {//优化：只有最小数字不是第一个数时才有必要排序，最小数字是第一个数时不进行排序
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
            System.out.printf("第%d轮选择排序：", i + 1);
            System.out.println(Arrays.toString(array));
        }
//          //第一轮
//        int index = 0;
//        int min = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if(array[i]<min){
//                min = array[i];
//                index = i;
//            }
//        }
//        array[index] = array[0];
//        array[0] = min;

//          //第二轮
//        index = 1;
//        min = array[1];
//        for (int i = 2; i < array.length; i++) {
//            if(array[i]<min){
//                min = array[i];
//                index = i;
//            }
//        }
//        array[index] = array[1];
//        array[1] = min;

//          //第三轮
//        index = 2;
//        min = array[2];
//        for (int i = 3; i < array.length; i++) {
//            if(array[i]<min){
//                min = array[i];
//                index = i;
//            }
//        }
//        array[index] = array[2];
//        array[2] = min;

        return array;
    }

    //插入排序
    //第一轮将第一个数看作一个有序序列，后面的N-1个数看作是一个无序序列，从无序序列中找出最小的数和有序序列所有数字比较，插入到有序序列中合适的位置
    //第二轮将前两个数字看作一个有序序列，后面的N-2个数字看作是一个无序序列......
    //.....
    public static int[] insert(int[] array) {
        //[0,0]位置是天然有序的
        //想让[1,n-1]有序
        for (int i = 1; i < array.length; i++) {
            //无序部分的头 和 有序部分的尾逆序比较,小的放到前面
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; --j) {
                swap(array, j, j + 1);
            }
        }
        return array;

    }

    //希尔排序：插入排序的基础上改进（分组插入）
    //交换式希尔排序
    public static void shellSort1(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {//增量递减,第一次增量为gap=length/2,递减：gap/=2
            for (int i = gap; i < array.length; i++) {
                //相距为gap的数为一组,i-gap-gap...,..i-gap,i
                //做直接插入排序
                //j=i-gap,相距为gap的数据为一组
                for (int j = i - gap; j >= 0; j -= gap) {//交换法希尔排序
                    if (array[j] > array[j + gap]) {
                        int temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
//                int j = i;
//                int temp = array[j];//前面的数视为有序序列,临时变量存储
//                while (j - gap >= 0 && array[j] < array[j - gap]) {
//                    array[j] = array[j - gap];
//                    j -= gap;
//                }
//                array[j] = temp;

            }
        }
    }

    //移位式希尔排序
    public static void shellSort2(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {//增量递减,第一次增量为gap=length/2,递减：gap/=2
            for (int i = gap; i < array.length; i++) {
                //相距为gap的数为一组,i-gap-gap...,..i-gap,i
                //做直接插入排序
                int j = i - gap;
                int temp = array[i];
                while (j >= 0 && array[j] > temp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = temp;


            }
        }

    }

    //快速排序1(有bug)
    public static void quick(int[] array, int left, int right) {//基准值取数组最左边或最右边的数
        int l = left;
        int r = right;
        int stand = array[left];//基准值取数组最左（右）边的数：查找的话要从最右（左）边开始查找
        while (l < r) {
            while (l < r && array[r] >= stand) {//从右往左找比stand小的数，大的话就继续
                r--;
            }//while循环结束array[r]就是比stand小的数
            array[l] = array[r];

            while (l < r && array[l] <= stand) {//从左往右找比stand大的数，小的话就继续
                l++;
            }//while循环结束array[l]就是比stand大的数
            array[r] = array[l];
        }//while循环结束之后指针l和指针r碰面
        array[l] = stand;//或者array[r]=stand


        //左边递归
        if (left < r) {
            quick(array, left, r - 1);

        }
        //右边递归
        if (r < right) {
            quick(array, l + 1, right);
        }


    }

    //快速排序2
    public static void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        //基准值取数组中间的数
        int stand = array[(left + right) / 2];
        while (l < r) {
            while (l < r && array[r] > stand) {//从右往左查找比stand小的数，大的话继续找（r--）
                r--;
            }//while循环结束之后,array[r]就是右半边比stand小的数
            while (l < r && array[l] < stand) {//从左往右找比stand大的数，小的话就继续找（l++）
                l++;
            }//while循环结束之后,array[l]就是左半边比stand大的数
            if (l >= r) {//
                break;
            }
            //交换位置
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            if (array[l] == stand) {
                r--;
            }
            if (array[r] == stand) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        //左边递归
        if (left < r) {
            quickSort(array, left, r);
        }
        //右边递归
        if (l < right) {
            quickSort(array, l, right);
        }

    }

    //归并排序（分治思想）
    //一个无序数组可分成两个有序数组（但这两个有序数组拼起来可能并不是有序的）
    //比较两个有序数组，小的数放到临时数组前边，大的数就放到临时数组后边
    //最后顺序将临时数组里的数还原到原始数组，原始数组就是完全有序的了
    public static void mergeSort(int[] array, int left, int right) {
        int mid = left + (right - left) >> 1;
        if (left < right) {
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    /**
     * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
     * <p>
     * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置；
     * <p>
     * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
     * <p>
     * 4.重复步骤 3 直到某一指针达到序列尾；
     * <p>
     * 5.将另一序列剩下的所有元素直接复制到合并序列尾。
     *
     * @param array 整体是无序数组，但分开来看是两个有序小数组   {2,4,6,1,3,5,7}
     * @param left  数组参与排序部分的头部索引
     * @param mid   左右两个有序数组分界处
     * @param right 数组参与排序部分的尾部索引
     */
    public static void merge(int[] array, int left, int mid, int right) {
        //临时数组存放归并之后有序的数据
        int[] temp = new int[right - left + 1];
        //临时数组的索引
        int index = 0;
        //数组两部分的索引
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            //三元运算符
            temp[index++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        //下面两个while循环只会走一个
        while (i <= mid) {//左边数组长,
            temp[index++] = array[i++];
        }
        while (j <= right) {//右边数组长
            temp[index++] = array[j++];
        }
        //把临时数组里的数放回原始数组（从排序区间起点放,left）
        for (int k = 0; k < temp.length; k++) {
            array[k + left] = temp[k];
        }
    }

    public static void RadixSort(int[] array) {
        //最大值
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //最大值的长度
        int maxLength = (max + "").length();

        //二维临时数组
        //0~9一共10个桶，每个桶里最多有array.length个元素
        int[][] bucket = new int[10][array.length];

        //桶内元素个数计数器（一维数组）,长度为10（0~9十个桶）,记录每个桶里的元素个数
        //BucketElementCount[1]=n,1这个桶里有n个元素
        int[] BucketElementCount = new int[10];

        //把原始数组里的元素放到二维数组每个桶里面
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < array.length; j++) {
                //余数,也就是桶(最多有0~9这十种可能)
                int remainder = array[j] / n % 10;
                bucket[remainder][BucketElementCount[remainder]] = array[j];
                BucketElementCount[remainder]++;//相应桶里的元素个数++
            }//for循环每走完一轮,就代表array数组里所有元素按某位(个,十,百,,,)入桶完毕

            //把二维数组里的元素按照新的顺序放回原始数组重新排序成新的数组
            //遍历每个桶，如果桶里有元素就取出放到原来数组里
            int index = 0;
            for (int j = 0; j < BucketElementCount.length; j++) {//j代表桶
                if (BucketElementCount[j] != 0) {
                    for (int k = 0; k < BucketElementCount[j]; k++) {//k是桶里元素的个数
                        array[index++] = bucket[j][k];
                    }//for循环走完，一个桶里的元素就取完了
                    //记录桶里元素个数的数置0
                    BucketElementCount[j] = 0;
                }
            }
//            System.out.println(Arrays.toString(array));
        }
    }

    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

}
