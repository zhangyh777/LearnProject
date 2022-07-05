package com.zyh.hsp_datastructure.datastructure.Tree;

import java.util.*;

/**
 * 霍夫曼树
 * 当用 n 个结点（都做叶子结点且都有各自的权值）试图构建一棵树时，如果构建的这棵树的带权路径长度(WPL)最小，称这棵树为“最优二叉树”，有时也叫“赫夫曼树”
 * * * 权重越大的结点离树根越近
 * <p>
 * 1.先将所有元素按照某个标准（节点的权值）排好序，每个元素都是一个节点（支持排序），每个节点又可以看作一棵最简单的二叉树
 * 2.取出权值最小的两棵二叉树组成一个新的二叉树（左右子节点是这两个权值最小的，根节点是两者的加和）
 * 3.把新的二叉树和之前剩下的别的二叉树以同样的标准再次排序，不断重复，直到所有的元素都被处理就组成了霍夫曼树
 */
public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] arr = {6,5,3,7,9,8};
        HuffNode root = createHuffmanTree(arr);
        preOrder(root);
    }


    public static void preOrder(HuffNode root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }

    //创建霍夫曼树
    public static HuffNode createHuffmanTree(int[] arr) {

        List<HuffNode> nodeList = new ArrayList<>();
        //把数组里的元素封装成Node对象,存放到ArrayList中
        for (int value : arr
        ) {
            nodeList.add(new HuffNode(value));
        }
        //创建霍夫曼树
        while (nodeList.size() > 1) {//3.循环处理,直到ArrayList中只剩一个元素（）
            //1.对ArrayList里的HuffNode类对象排序（排序规则由重写的compareTo方法定义）
            Collections.sort(nodeList);
            //2.1.取出权值最小的两个二叉树
            HuffNode left = nodeList.get(0);
            HuffNode right = nodeList.get(1);
            //2.2.组成新的二叉树
            //新的父节点
            HuffNode parent = new HuffNode(left.value + right.value);
            //父节点挂上左右子节点
            parent.left = left;
            parent.right = right;
            //2.3.删除前面取出的节点,添加二者组合成的父节点
            nodeList.remove(left);
            nodeList.remove(right);
            nodeList.add(parent);
        }
        //
        return nodeList.get(0);

    }
}

//Node类对象要支持排序
class HuffNode implements Comparable<HuffNode> {
    public int value;

    public HuffNode left;
    public HuffNode right;

    public HuffNode(int value) {
        this.value = value;
    }



    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(HuffNode node) {
        //我减它升序,它减我降序
        return this.value - node.value;
    }

    @Override
    public String toString() {
        return "HuffNode [value=" + value + "]";
    }


}
