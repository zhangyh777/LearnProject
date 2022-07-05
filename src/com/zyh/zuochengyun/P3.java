package com.zyh.zuochengyun;


import java.util.Arrays;

/**
 * 堆
 */
public class P3 {
    public static void main(String[] args) {
        int[] arr = {7,4,2,1,8,6,3,9,5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //堆化
        //开始位置是最后一个叶子节点的父节点（也是最后一个非叶子节点）
        //最后一个叶子节点的索引为 arr.length-1
        //它的父节点就为 (arr.length-1-1)/2
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        //交换堆顶和堆尾的元素+重新堆化
        for (int i = arr.length-1; i >0; i--) {
            //交换
            swap(arr,0,i);
            //交换之后要重新调整堆为大顶堆
            //从0开始是因为一开始的堆就是大顶堆,元素交换之后只有第一个父节点（根节点）那里不是大顶堆了
            //别的节点都满足大顶堆,所以从0开始就行
            heapify(arr,0,i);
        }
    }

    /**
     * 堆化，调整数组为大顶堆或者小顶堆
     *
     * @param arr
     * @param parent
     * @param size
     */
    public static void heapify(int[] arr, int parent, int size) {
        //父节点
        int temp = arr[parent];

        for (int cur = 2 * parent + 1; cur < size; cur = 2 * cur + 1) {
            //1.存在右子节点
            //2.左右两个子节点比较大小,
            if (cur + 1 < size && arr[cur] < arr[cur + 1]) {
                cur = cur + 1;
            }
            //较大的那个子节点也比父节点大的话
            if (arr[cur] > temp) {
                //把大的子节点放到父节点位置上
                arr[parent] = arr[cur];
                //父节点的索引更新为大的子节点的索引
                parent = cur;
            } else {
                break;
            }
        }
        arr[parent] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
