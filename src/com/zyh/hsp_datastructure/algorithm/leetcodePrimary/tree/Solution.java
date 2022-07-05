package com.zyh.hsp_datastructure.algorithm.leetcodePrimary.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        Tree tree = new Tree();
        tree.head = head;

        head.left = node2;
        head.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(tree.preOrder(head));


    }


}

class Tree {
    List<TreeNode> res = new ArrayList<>();

    public TreeNode head;

    public Tree() {
    }


    //前序遍历（递归）
    public List<TreeNode> preOrder(TreeNode head) {

        if (head == null) {
            return new ArrayList<>();
        }

        res.add(head);
        //System.out.println(head);
        preOrder(head.left);
        preOrder(head.right);
        return res;
    }

    //中序遍历（递归）
    public void infixOrder(TreeNode head) {
        if (head == null) {
            return;
        }

        infixOrder(head.left);

        res.add(head);
        //System.out.println(head);

        infixOrder(head.right);
    }

    //后序遍历（递归）
    public List<TreeNode> postOrder(TreeNode head) {
        if (head == null) {
            return null;
        }

        postOrder(head.left);
        postOrder(head.right);
        res.add(head);
        //System.out.println(head);
        return res;
    }

    //前序遍历（非递归）
    //1.根节点入栈
    //2.如果栈不为空（while(!stack.isEmpty()){...}）
    //  2.1.节点出栈,处理（打印或者存入数组...）
    //  2.2.先压右子节点(如果有),再压左子节点(如果有)
    public List<TreeNode> preOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();

                res.add(head);
                //System.out.println(head);

                //因为是栈结构先进后出,遍历时是先左后右,入栈时就要先右后左
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        return res;
    }

    //中序遍历（非递归）
    public List<TreeNode> infixOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {//揪着一个节点一直往下找左子节点,入栈,直到节点为空为止
                    stack.push(head);
                    head = head.left;//找当前节点的左子节点,设为新的当前节点
                } else {
                    //节点出栈,处理（打印或者存入数组）
                    head = stack.pop();

                    res.add(head);
                    //System.out.println(head);

                    //当前节点变为当前节点的右子节点,重复进行上面的操作
                    head = head.right;
                }
            }
        }
        return res;
    }

    //后序遍历（非递归）
    public List<TreeNode> postOrderUnRecur(TreeNode head) {

        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                res.add(s2.pop());
                System.out.println(s2.pop());
            }
        }
        return res;
    }


    /*
        通过二叉树的前中后序遍历数组中的两种来还原二叉树的话,必须要有中序遍历（有中序遍历的话就能确定左右子树的长度,通过前或者后可以确定根节点）
     */

    /**
     * 由二叉树的前序遍历和中序遍历还原二叉树
     *
     * @return
     */
    public static TreeNode buildTreeByPre(int[] preOrder, int[] infixOrder) {
        return buildTreeByPre(preOrder, 0, preOrder.length - 1, infixOrder, 0, infixOrder.length - 1);
    }

    public static TreeNode buildTreeByPre(int[] preOrder, int preL, int preR, int[] infixOrder, int inL, int inR) {
        if (inL > inR || preL > preR) {
            return null;
        }

        //根节点
        int rootVal = preOrder[preL];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inL;

        for (int i = inL; i <= inR; i++) {
            if (infixOrder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTreeByPre(preOrder, preL + 1, preL + (rootIndex - inL),/*左子树在前序遍历数组里的区间*/
                infixOrder, inL, rootIndex - 1/*左子树在中序遍历数组里的区间*/);

        root.right = buildTreeByPre(preOrder, preL + (rootIndex - inL) + 1, preR,/*右子树在前序遍历数组里的区间*/
                infixOrder, rootIndex + 1, inR/*右子树在中序遍历数组里的区间*/);
        return root;
    }

    /**
     * 由二叉树的后序遍历和中序遍历还原二叉树
     *
     * @return
     */
    public static TreeNode buildTreeByPost(int[] infixOrder, int[] postOrder) {
        return buildTreeByPost(infixOrder, 0, infixOrder.length, postOrder, 0, postOrder.length);
    }

    /**
     * @param infixOrder 中序遍历数组
     * @param inL
     * @param inR
     * @param postOrder  后序遍历数组
     * @param postL
     * @param postR
     * @return
     */
    public static TreeNode buildTreeByPost(int[] infixOrder, int inL, int inR,
                                           int[] postOrder, int postL, int postR) {
            /*
            后序遍历：左  右   根
            中序遍历：左  根   右
            1.由后序遍历数组可以确定二叉树的根节点,
            2.在中序遍历数组找到根节点所在位置,左半部分即为左子树的中序遍历,右半部分即为右子树的中序遍历
            3.根据左子树的中序遍历的长度和右子树的中序遍历的长度可以确定左子树后序遍历的长度和右子树后序遍历的长度,
              ,继而在后序遍历数组中找到左子树的后序遍历部分,右子树的后序遍历部分
            4.递归
         */
        if (inR - inL < 1) {
            return null;
        }
        if (inR - inL == 1) {
            return new TreeNode(infixOrder[inL]);
        }
        //后序遍历数组的最后一个数字是二叉树根结点的值
        int rootVal = postOrder[postR - 1];
        //创建根节点
        TreeNode root = new TreeNode(rootVal);
        //索引
        int rootIndex = inL;
        //在中序遍历数组中定位到根节点所在的位置
        for (int i = inL; i < inR; i++) {
            if (infixOrder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        /*

            左右子树的长度是固定的,无论是哪种方式的遍历,左子树的长度都是固定的,右子树的长度也是固定的

            切割中序数组
            [inL,rootIndex]区间是左子树的中序遍历（左子树的长度就是rootIndex-inL）
            [rootIndex+1,inR]区间是右子树的中序遍历（右子树的长度就是   ）

            切割后序数组
            左子树在后序遍历数组中的起点是postL,子树的长度是rootIndex-inL,那么左子树的区间就是[postL,postL+(toorIndex-inL)]
            [postL,postL+(rootIndex-inL)]是左子树的后序遍历
            [postL+(rootIndex-inL),postR-1]是右子树的后序遍历
         */
        //递归
        root.left = buildTreeByPost(infixOrder, inL, rootIndex,/*左子树在中序遍历数组里的区间*/
                postOrder, postL, postL + (rootIndex - inL)/*左子树在后序遍历数组里的区间*/);

        root.right = buildTreeByPost(infixOrder, rootIndex + 1, inR,/*右子树在中序遍历数组里的区间*/
                postOrder, postL + (rootIndex - inL), postR - 1/*右子树在后序遍历数组里的区间*/);
        return root;
    }

    /**
     * 二叉树最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }


    /**
     * 给出有序数组nums,将其转换为一棵高度平衡的搜索二叉树
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);

    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
    /*
        因为数组nums是升序数组,而搜索二叉树的中序遍历数组也是升序数组,所以nums也是搜索二叉树的中序遍历数组
        仅仅由中序遍历无法确定唯一的二叉搜索树,如果要求搜索二叉树高度平衡,这也无法确定唯一的二叉搜索树,但二叉树的形式缩小到有限个
        如果要求二叉搜索树高度平衡,那么必须选择中序遍历数组中间节点作为根节点,这样左右子树的长度(高度)差最大为1,

     */
        if (left > right) {
            return null;
        }
        //选择中间数字为根节点
        int mid = (right + left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        //递归
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;

    }

    /**
     * 110.给定二叉树根节点,判断二叉树是否是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /**
     * @param head
     * @return
     */
    public int height(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftHeight = height(head.left);
        int rightHeight = height(head.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }


    /**
     * 111.二叉树的最小深度
     * <p>使用深度优先搜索的方法，遍历整棵树，记录最小深度。
     * 对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题</p>
     * @param head
     * @return
     */
    public int minDepth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        //叶子节点
        if (head.left == null && head.right == null) {
            return 1;
        }
        int res = Integer.MAX_VALUE;
        if (head.left != null) {
            res = Math.min(minDepth(head.left), res);
        }
        if (head.right != null) {
            res = Math.min(minDepth(head.right), res);
        }
        return res + 1;
    }

    /**
     * 112.路径总和
     * <p>给定根节点和目标值,判断二叉树上是否存在 根节点到叶子节点的路径,路径上节点的和等于目标值</p>
     * @param root          二叉树根节点
     * @param targetSum     目标和
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        if (root.left==null&&root.right==null){
            return root.val==targetSum;
        }
        return hasPathSum(root.left,targetSum- root.val)||hasPathSum(root.right,targetSum- root.val);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "[TreeNode:val=" + this.val + "]";
    }
}
