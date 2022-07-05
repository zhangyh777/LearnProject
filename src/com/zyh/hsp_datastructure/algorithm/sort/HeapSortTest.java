package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序（是一种选择排序）
 * 大顶堆：每个节点的值都大于等于左右子节点的值，但左右子节点的大小不要求
 * 小顶堆：每个节点的值都小于等于左右子节点的值，左右子节点的大小不要求
 * 一般用堆排序的话：升序用大顶堆，降序用小顶堆
 */
public class HeapSortTest {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
    public static void HeapSort(int[] arr) {
        //1.创建大顶堆
        //开始位置是最后一个叶子节点的父节点（也是最后一个非叶子节点）
        //最后一个叶子节点的索引为 arr.length-1
        //它的父节点就为 (arr.length-1-1)/2
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {//i--
            heapify(arr, i, arr.length);
        }

        //2.交换堆顶和堆尾元素+重新调整堆结构
        for (int i = arr.length - 1; i > 0; i--) {
            //堆顶元素和堆尾元素交换位置
            swap(arr,0,i);

            //交换之后要重新调整堆为大顶堆
            //从0开始是因为一开始的堆就是大顶堆,元素交换之后只有第一个父节点（根节点）那里不是大顶堆了
            //别的节点都满足大顶堆,所以从0开始就行
            heapify(arr, 0, i);
        }
    }


    /**
     * 调整为大（小）顶堆
     * @param arr    待转换数组
     * @param parent 父节点在数组中的索引,从这里开始调整
     * @param size   参与调整的元素的个数,逐渐减少的
     * <p>
     * 数组用树表示的规定：
     * 假设父节点在数组的索引值为index</p>
     * <p>
     * 那么左子节点是数组里索引为 2*index+1 的数</p>
     * <p>
     * 右子节点是数组里索引为 2*index+2 的数</p>
     * <p>
     * 它自己的父节点是数组里索引为 （index-1）/2 的数</p>
     */
    public static void heapify(int[] arr, int parent, int size) {
        int temp = arr[parent];//临时变量存放父节点的值
        for (int k = 2 * parent + 1; k < size; k = 2 * k + 1) {
            //k = 2*parent+1 是当前父节点的左子节点的索引
            //k+1 即 2*parent+2 是当前父节点的右子节点的索引
            //循环变量k自增：k=2*k+1是因为下一个作为父节点的节点是当前节点的左子节点（如果有的话）
            if (k + 1 < size && arr[k] < arr[k + 1]) {
                //1.不越界
                //2.右子节点的值大于左子节点的值的话
                k = k + 1;//指向值较大的右子节点
            }
            if (arr[k] > temp) {//较大的子节点的值和父节点相比较,子节点的值大于父节点的值
                //子节点和父节点交换位置
                arr[parent] = arr[k];
                parent = k;//把父节点的索引更新为大的子节点的索引
            } else {//子节点的值小于等于父节点的值的话就不用比较了
                break;
            }
        }
        arr[parent] = temp;
    }
}



