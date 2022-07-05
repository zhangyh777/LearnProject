package com.zyh.hsp_datastructure.datastructure.Tree;

import java.util.Stack;

public class Test {
    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode[value=" + value + "]";
        }
    }

    static class TreeTest {
        private TreeNode head;

        public TreeTest() {
        }

        public TreeNode getHead() {
            return head;
        }

        public void setHead(TreeNode head) {
            this.head = head;
        }


        //递归前中后序遍历
        public void preOrder(TreeNode head) {
            if (head == null) {
                return;
            }
            System.out.println(head);
            preOrder(head.left);
            preOrder(head.right);
        }

        public void infixOrder(TreeNode head) {
            if (head == null) {
                return;
            }
            infixOrder(head.left);
            System.out.println(head);
            infixOrder(head.right);
        }

        public void postOrder(TreeNode head) {
            if (head == null) {
                return;
            }
            postOrder(head.left);
            postOrder(head.right);
            System.out.println(head);
        }
        //非递归前中后序遍历

        public void preUnRecur(TreeNode head) {
            if (head != null) {
                Stack<TreeNode> stack = new Stack<>();
                stack.push(head);
                while (!stack.isEmpty()) {
                    head = stack.pop();
                    System.out.println(head);
                    if (head.right != null) {
                        stack.push(head.right);
                    }
                    if (head.left != null) {
                        stack.push(head.left);
                    }
                }
            }
        }

        public void infixUnRecur(TreeNode head) {
            if (head != null) {
                Stack<TreeNode> stack = new Stack<>();
                while (!stack.isEmpty() || head != null) {

                    if (head != null) {
                        stack.push(head);
                        head = head.left;
                    } else {
                        head = stack.pop();
                        System.out.println(head);
                        head = head.right;
                    }
                }
            }
        }

        public void postUnRecur(TreeNode head) {
            if (head != null) {
                Stack<TreeNode> s1 = new Stack<>();
                Stack<TreeNode> s2 = new Stack<>();
                s1.push(head);
                while (!s1.isEmpty()){
                    head=s1.pop();
                    s2.push(head);
                    if (head.left!=null){
                        s1.push(head.left);
                    }
                    if (head.right!=null){
                        s1.push(head.right);
                    }
                }
                while (!s2.isEmpty()){
                    System.out.println(s2.pop());
                }
            }

        }
    }

    public static void main(String[] args) {
        TreeTest tree = new TreeTest();

        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode head = new TreeNode(1, node2, node3);
        System.out.println("递归前序遍历：");
        tree.preOrder(head);
        System.out.println("非递归前序遍历：");
        tree.preUnRecur(head);
        System.out.println("递归中序遍历：");
        tree.infixOrder(head);
        System.out.println("非递归中序遍历：");
        tree.infixUnRecur(head);
        System.out.println("递归后序遍历：");
        tree.postOrder(head);
        System.out.println("非递归后序遍历：");
        tree.postUnRecur(head);

    }
}


