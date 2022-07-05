package com.zyh.hsp_datastructure.algorithm.sort;
import java.util.Arrays;
import com.zyh.hsp_datastructure.datastructure.Queue_.ArrayQueue.ArrayQueue;

/**
 * 基数排序：
 * 将数组里的数先 按照个位数字放到不同数组里，然后再把数字从这些数组里取出生成和原数组array不同的数组array1
 * 将新数组array1里的数 按照十位数字放到不同数组里，然后再把数字从这些数组里取出生成和array1不同的数组array2
 * 千位，万位，，依此类推
 * 当把数组里的数字按照最大数字的最高位放置完之后，从这些数组里取出数字就是排好序的数组
 * 假如数组为：{907, 570, 21, 33, 513, 40, 73, 17, 82, 49}
 * 0       1       2       3       4       5       6       7       8       9
 * 按个位数字：       570     21      82      33                              907             49
 * 40                      513                             17
 * 73
 * 新数组：   {570,40,21,82,33,513,73,907,17,49}
 * <p>
 * 按十位数字：       907     17      21      33      40                      570     82
 * 513                     49                      73
 * 新数组：  {907,17,513,21,33,40,49,570,73,82}
 * <p>
 * 按百位数字：       17                                      513                              907
 * 21                                      570
 * 33
 * 40
 * 49
 * 73
 * 82
 * 最终数组：   {17,21,33,40,49,73,82,513,570,907}
 */
public class RadixSortTest {
    public static void main(String[] args) {
        int[] arr = {907, 570, 21, 33, 513, 40, 73, 17, 82, 49};
        RadixSortByQueue(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void RadixSortByQueue(int[] array) {
        int max = array[0];//数组里最大的数，先假设为array[0]
        for (int i = 0; i < array.length; i++) {//找出最大的数
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();//数组里最大的数字的长度

        //将数组里的所有数字按照 个十百千...位上的数字放入新数组
        //个位：num/1%10
        //十位：num/10%10
        //百位：num/100%10
        //...
        //临时二维数组存放原数组里的数字,个十百千..位总计共有10种可能（0~9,10个桶）,每个桶里最多有array.length个数字



        //队列数组（十个队列,每个队列看作一个桶）
        ArrayQueue[] tempQueue = new ArrayQueue[10];
        //给队列分配大小
        for (int i = 0; i < tempQueue.length; i++) {
            tempQueue[i] = new ArrayQueue(array.length);
        }

        //根据最大数字的长度决定比较的次数,比较一次就是个位，两次就是百位，，，
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //数组里的每个数字取余数
            for (int j = 0; j < array.length; j++) {
                int remainder = array[j] / n % 10;//余数
                tempQueue[remainder].enQueue(array[j]);//入队
            }//这个for循环走完,array就完成了一次按位装桶（循环第一次：个位  循环第二次：百位，，，）

            //从桶里（队列）取出元素放回原始数组
            int index = 0;
            for (int k = 0; k < tempQueue.length; k++) {//k代表桶
                while (!tempQueue[k].isEmpty()){
                    array[index++] = tempQueue[k].deQueue();
                }
            }
        }
    }

    public static void RadixSort(int[] array) {
        int max = array[0];//数组里最大的数，先假设为array[0]
        for (int i = 0; i < array.length; i++) {//找出最大的数
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();//数组里最大的数字的长度

        //将数组里的所有数字按照 个十百千...位上的数字放入新数组
        //个位：num/1%10
        //十位：num/10%10
        //百位：num/100%10
        //...
        //临时二维数组存放原数组里的数字,个十百千..位总计共有10种可能（0~9,10个桶）,每个桶里最多有array.length个数字
        int[][] temp = new int[10][array.length];

        //计数器数组,长度为10,代表0~9,记录桶里数字的个数
        //counts[0]=n,就是说0这个桶里有n个数
        int[] counts = new int[10];

        //根据最大数字的长度决定比较的次数,比较一次就是个位，两次就是百位，，，
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //数组里的每个数字取余数
            for (int j = 0; j < array.length; j++) {
                int remainder = array[j] / n % 10;//余数
                //将array[j]这个数放到remainder这个桶里第counts[remainder]个位置上
                temp[remainder][counts[remainder]] = array[j];
                //remainder这个桶里的数字个数++
                counts[remainder]++;
            }//这个for循环走完,array就完成了一次按位装桶（一次：个位  两次：百位，，，）

            //从临时二维数组里取出数字放回原数组
            //取出顺序和添加顺序一致（即先进先出，符合队列的性质）
            int index = 0;
            for (int k = 0; k < counts.length; k++) {//k代表桶
                if (counts[k] != 0) {//如果这个桶里有数
                    //循环取出该桶里的数
                    for (int l = 0; l < counts[k]; l++) {//l代表桶里数字的个数
                        array[index++] = temp[k][l];
                    }
                    //for循环结束,桶里的数就取完了,个数置0
                    counts[k] = 0;
                }
            }
        }
    }
}
