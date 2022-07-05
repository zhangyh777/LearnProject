package com.zyh.hsp_datastructure.datastructure.Tree;

/**
 *
 *  顺序存储二叉树：只考虑完全二叉树
 *  用数组表示二叉树（用二叉树的中序，前序，后续遍历法来遍历数组）
 *  假设节点在数组的索引值为index，
 *  那么节点的左子节点是数组里索引为 2*index+1 的数
 *     节点的右子节点是数组里索引为 2*index+2 的数
 *     它的父节点是数组里索引为 （index-1）/2 的数
 */
public class ArrBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
        System.out.println("==========");
        arrBinaryTree.infixOrder(0);
        System.out.println("==========");
        arrBinaryTree.postOrder(0);
    }
}
class ArrBinaryTree{
    int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //前序遍历
    public void preOrder(int index){
        if (arr==null||arr.length==0){
            return;
        }
        System.out.println(arr[index]);
        if ((2*index+1)<arr.length){
            preOrder(2*index+1);
        }
        if((2*index+2)<arr.length){
            preOrder(2*index+2);
        }

    }
    //中序遍历
    public void infixOrder(int index){
        if (arr==null||arr.length==0){
            return;
        }
        if ((2*index+1)<arr.length){
            infixOrder(2*index+1);
        }
        System.out.println(arr[index]);
        if((2*index+2)<arr.length){
            infixOrder(2*index+2);
        }

    }
    //中序遍历
    public void postOrder(int index){
        if (arr==null||arr.length==0){
            return;
        }
        if ((2*index+1)<arr.length){
            postOrder(2*index+1);
        }
        if((2*index+2)<arr.length){
            postOrder(2*index+2);
        }
        System.out.println(arr[index]);

    }
}
