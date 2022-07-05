package com.zyh.hsp_datastructure;

import com.zyh.demo.primary.extend_.exercise.B;

import java.util.*;

/**
 * 霍夫曼编码
 * <p>
 * 1.统计字符串字符个数
 * 2.创建霍夫曼树
 * 3.创建霍夫曼编码
 * 4.编码
 */
public class HuffmanCoding {
    public static void main(String[] args) {
        /*
            对应二进制
            01100011011000010110111000100000011110010110111101110101001000000110001101100001011011100010000001100001001000000110001101100001011011100010000001100001011100110010000001100001001000000110001101100001011011100010000001100011011000010110111001101110011001010111001000100000011000110110000101101110001000000110000100100000011000110110000101101110
            对应的byte数组
            [99, 97, 110, 32, 121, 111, 117, 32, 99, 97, 110, 32, 97, 32, 99, 97, 110, 32, 97, 115, 32, 97, 32, 99, 97, 110, 32, 99, 97, 110, 110, 101, 114, 32, 99, 97, 110, 32, 97, 32, 99, 97, 110]
         */
        String content = "can you can a can as a can canner can a can";
        byte[] contentBytes = content.getBytes();//字符串转byte数组

        ArrayList<ND> arrayList = getNODEs(contentBytes);
//        //霍夫曼树
        ND root = createHuffmanTree(arrayList);
//        //霍夫曼编码表
        Map<Byte,String> huffmanCode = getCode(root);
        System.out.println("霍夫曼编码表："+huffmanCode);




    }


    /**
     * 封装
     * 霍夫曼编码压缩
     * @param bytes 原始的字符串对应的字节数组
     * @return
     */
    public static byte[] huffmanZip(byte[] bytes) {
        //统计字节数组中每个字节出现的次数,将字节-次数封装成ND对象,放到ArrayList中,为了后面创建霍夫曼树
        ArrayList<ND> arrayList = getNODEs(bytes);
        //霍夫曼树
        ND root = createHuffmanTree(arrayList);
        //根据霍夫曼树创建霍夫曼编码表
        Map<Byte, String> huffmanCodes = getCode(root);

        //进行霍夫曼编码,把原始字符串对应的byte数组换成相应的二进制byte数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;

    }

    /**
     * 进行霍夫曼编码
     * 原始字符串对应的霍夫曼编码
     * 利用霍夫曼编码表对霍夫曼编码进行压缩得到霍夫曼编码字节数组
     * @param bytes        原始字符串对应的字节数组
     * @param huffmanCodes 已有的霍夫曼编码表
     * @return 返回霍夫曼编码处理后的二进制byte[]
     *
     * String content = "can you can a can as a can canner can a can"
     *  -> byte[] contentBytes = content.getBytes();
     *  [99, 97, 110, 32, 121, 111, 117, 32, 99, 97, 110, 32, 97, 32, 99, 97, 110, 32, 97, 115, 32, 97, 32, 99, 97, 110, 32, 99, 97, 110, 110, 101, 114, 32, 99, 97, 110, 32, 97, 32, 99, 97, 110]
     *
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.原始字节数组转换成霍夫曼编码(虽然比原始字符串对应的字节数组短,但还是要比原始字符串长),
        //2.把霍夫曼编码压缩得到霍夫曼编码字节数组(比原始字符串短)
        /*
            利用霍夫曼编码表把byte数组里的byte转换成霍夫曼编码对应的字符串

            原始字符串 String content = "can you can a can as a can canner can a can";
            字节转二进制（定长编码,一个字节长度为8位）
            c -> 01100011
            a -> 01100001
            n -> 01101110
            空格 -> 00100000
            s -> 01110011
            y -> 01111001
            o -> 01101111
            u -> 01110101
            e -> 01100101
            r -> 01110010
            原始字符串对应的二进制字符串（344位）
            01100011011000010110111000100000011110010110111101110101001000000110001101100001011011100010000001100001001000000110001101100001011011100010000001100001011100110010000001100001001000000110001101100001011011100010000001100011011000010110111001101110011001010111001000100000011000110110000101101110001000000110000100100000011000110110000101101110

            原始字符串对应的霍夫曼编码字符串（115位）
            1111000011100011001110110011111000011001111100001101101010110011111000011111000001101111101000111110000110011111000
            对应关系
            111         c
            10          a
            00          n
            01          空格
            11000       y
            11001       o
            110110      u
            01          空格
            111         c
            10          a
            00          n
            01          空格
            10          a
            01          空格
            111         c
            10          a
            00          n
            01          空格
            10          a
            110101      s
            01          空格
            10          a
            01          空格
            111         c
            10          a
            00          n
            01          空格
            111         c
            10          a
            00          n
            00          n
            110111      e
            110100      r
            01          空格
            111         c
            10          a
            00          n
            01          空格
            10          a
            01          空格
            111         c
            10          a
            00          n
         */

        //1.根据霍夫曼编码表得到原始字符串的字节数组对应的霍夫曼编码
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes
        ) {
            sb.append(huffmanCodes.get(b));
        }
        //2.压缩霍夫曼编码,得到霍夫曼编码的字节数组
        int len;
        if (sb.length() % 8 == 0) {//8位一个字节,整除的情况
            len = sb.length() / 8;
        } else {//不能整除的情况,长度要+1
            len = (sb.length() / 8) + 1;
        }
        //霍夫曼编码字节数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i+=8) {
            String subString;
            if (i+8>sb.length()){//不够8位的话
                subString = sb.substring(i);
            }else {
                subString = sb.substring(i,i+8);
            }
            huffmanCodeBytes[index]=(byte) Integer.parseInt(subString,2);//二进制
            index++;
        }
        return huffmanCodeBytes;
    }

    //拼接霍夫曼编码
    static StringBuilder sb = new StringBuilder();
    //霍夫曼编码表,key是字节,value是该字节对应的霍夫曼编码
    static HashMap<Byte, String> huffmanCodes = new HashMap<>();

    /**
     * 重构,方便调用
     * @param parent    霍夫曼树的节点
     * @return          霍夫曼编码表
     */
    public static Map<Byte, String> getCode(ND parent) {
        if (parent == null) {
            return null;
        }
        getCode(parent.left, "0", sb);
        getCode(parent.right, "1", sb);
        return huffmanCodes;
    }

    /**
     * 根据霍夫曼树创建霍夫曼编码表
     * @param node 节点
     * @param code 编码规范,左子节点路径为0,右子节点路径为1
     * @param sb   用于拼接编码路径
     */
    public static void getCode(ND node, String code, StringBuilder sb) {
        //新的StringBuilder
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.data == null) {//node是非叶子节点,根据霍夫曼树的定义,该节点是原始节点拼凑的父节点,递归继续往下找
            getCode(node.left, "0", sb2);
            getCode(node.right, "1", sb2);
        } else {//node是叶子节点
            huffmanCodes.put(node.data, sb2.toString());
        }

    }

    public static void preOrder(ND root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
        }
    }

    public static ND createHuffmanTree(ArrayList<ND> arrayList) {
        while (arrayList.size() > 1) {
            //1.排序
            Collections.sort(arrayList);
            //2.1.权值最小的两个节点
            ND left = arrayList.get(0);
            ND right = arrayList.get(1);
            //2.2.新的根节点
            ND parent = new ND(null, left.weight + right.weight);
            //2.3.根节点挂上左右子节点
            parent.left = left;
            parent.right = right;
            //2.4.删除两个子节点,添加新的根节点
            arrayList.remove(left);
            arrayList.remove(right);
            arrayList.add(parent);
        }

        return arrayList.get(0);
    }

    /**
     * 统计字节数组中每个字节出现的次数,和该字节构成key-value对,放到HashMap中,
     * 把HashMap中的key-value对封装成ND对象,存到ArrayList<ND>中,为了后续创建霍夫曼树
     * byte[] 转 List<ND>
     * HashMap 形如 [97=1,99=2,110=1,,,,]     字节97出现1次,字节99出现2次,,,
     * List 形如 [ND[data=97,weight=1],[ND[data=99,weight=2],,,]
     * @param byteArr
     * @return
     */
    public static ArrayList<ND> getNODEs(byte[] byteArr) {
        ArrayList<ND> nodeList = new ArrayList<>();

        //HashMap用来存放字节数组中每个字节以及每个字节出现的次数
        //key:data
        //value:weight
        Map<Byte, Integer> countMap = new HashMap<>();
        for (byte b : byteArr
        ) {
            //先看Map里面是否有这个字节,并计数
            Integer counts = countMap.get(b);
            if (countMap.get(b) == null) {//如果没有这个字节的话就把这个字节存到Map里,counts=1;
                countMap.put(b, 1);
            } else {//如果有这个字节的话,把这个字节放到Map里,counts+1;
                countMap.put(b, counts + 1);
            }
        }

        //把countMap里的key-value对封装成NODE对象再存到ArrayList<NODE>中
        for (Map.Entry<Byte, Integer> entry : countMap.entrySet()) {
            nodeList.add(new ND(entry.getKey(), entry.getValue()));
        }

        return nodeList;
    }




}

class ND implements Comparable<ND> {
    Byte data;
    int weight;
    ND left;
    ND right;

    public ND(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public void preOrder() {
        if (this == null) {
            return;
        }
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(ND node) {
        return this.weight - node.weight;
    }

    @Override
    public String toString() {
        return "ND [data= " + data + ",weight= " + weight + "]";
    }

}



