package com.zyh.hsp_datastructure.binarysortree;

/*
    二叉排序树：对于任意非叶子节点,它的左子节点比当前节点的值小,右子节点比当前节点的值大
 */
public class BinarySortTreeTest {
    public static void main(String[] args) {
        int[] arr = {7, 3, 1, 5, 6, 0, 9, 12, 11, 13};
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            binaryTree.add(new Node(arr[i]));
        }
        System.out.println("删除之前的中序二叉树：");
        binaryTree.infixOrder();

        binaryTree.delete(7);
        System.out.println("删除之后的中序二叉树");
        binaryTree.infixOrder();


    }
}

class BinaryTree {
    public Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树");
        }
    }


    public Node searchTarget(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchTarget(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


    /**
     * 排序二叉树删除节点,三种情况
     * 1.叶子节点
     * 2.只有一棵子树的非叶子节点
     * 3.有两棵子树的非叶子节点
     */

    //3.删除有两棵子树的节点
    //找到要删除的节点target
    //target节点的父节点parent
    //在target右子树找最小的（往左找） 或者 在target左子树找最大的（往右找）
    //临时变量 int tempVal = 右子树找到的最小的节点的值（或者左子树找到的最大的节点的值）
    //删除该节点,del3(tempVal)
    //target.value=tempVal;
    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            Node target = searchTarget(value);//查找要删除的目标节点,要么找到,要么找不到
            Node parent = searchParent(value);//找到要删除的节点的父节点
            if (target == null) {//找不到要删除的节点
                System.out.println("该排序二叉树里找不到要删除的节点");
                return;
            }
            //target找到了
            //1.target是叶子节点
            if (target.left == null && target.right == null) {
                if (parent == null) {//target还是根节点（即要删除的节点是孤零零一个根节点）
                    this.root = null;
                } else {//target不是根节点（是parent的左子节点或者右子节点）
                    if (parent.left != null && parent.left.value == target.value) {//要删除的节点是parent左子节点（叶子节点）
                        parent.left = null;
                    } else {//要删除的节点是parent右子节点（叶子节点）
                        parent.right = null;
                    }
                }
            }
            //3.要删除的节点有两棵子树
            //在右子树里面找最小的节点（往左找）
            //或者在左子树找最大的节点（往右找）
            else if (target.left != null && target.right != null) {
                //右子树找最小的节点（因为右边都是比父节点大的,所以找个最小的放到待删除节点,右边还是比新的当前节点大的）
                //int min = delRightTreeMin(target.right);
                //target.value = min;//右子树最小节点的值放到待删除的节点上,但删除的节点就更新了
                //或者
                //左子树找最大的节点（因为左边都是比父节点小的,所以找个最大的放到待删除结点,左边还是比新的当前节点小的）
                int max = delLeftTreeMax(target.left);
                target.value = max;

            }
            //2.要删除的节点只有一棵子树（左或者右）
            //只有一棵子树的情况包含2种：
            //                      1.根节点只有一棵子树
            //                      2.不是根节点的非叶子节点只有一棵子树
            //考虑该节点是不是根节点（parent是否为空）
            else {//要删除的节点只有一棵子树
                if (target.left != null && target.right == null) {//该节点只有左子树
                    if (parent == null) {//根节点,只有一棵左子树
                        this.root = target.left;
                    } else {//不是根节点
                        if (parent.left != null && parent.left.value == value) {//只有左子树
                            parent.left = target.left;
                        } else {//只有右子树
                            parent.right = target.left;
                        }
                    }
                } else if (target.right != null && target.left == null) {//该节点只有右子树
                    if (parent == null) {//根节点,只有一棵右子树
                        this.root = target.right;
                    } else {//不是根节点
                        if (parent.left != null && parent.left.value == value) {//只有左子树
                            parent.left = target.right;
                        } else {//只有右子树
                            parent.right = target.right;
                        }
                    }
                }
            }
        }
    }

    public int delRightTreeMin(Node node) {
        Node target = node;//记录最小节点
        while (target.left != null) {//往左子树找最小值
            target = target.left;
        }
        delete(target.value);//把最小节点删掉（因为要放到前面）

        return target.value;//最小节点的值保留,为了放到删除之后的空位上
    }

    public int delLeftTreeMax(Node node) {
        Node target = node;
        while (target.right != null) {
            target = target.right;
        }
        delete(target.value);
        return target.value;
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node[value=" + this.value + "]";
    }

    public void add(Node node) {

        if (node.value < this.value) {//小于当前节点的话
            if (this.left == null) {//当前节点左子节点为空就直接放到左子结点
                this.left = node;
            } else {//左子节点不为空就递归往下继续找
                this.left.add(node);
            }
        } else {//大于等于当前节点
            if (this.right == null) {//当前节点右子节点为空就直接放到右子节点
                this.right = node;
            } else {//右子节点不为空就递归往下继续找
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    //查找要删除的目标节点
    public Node searchTarget(int value) {
        if (this.value == value) {//当前节点就是要找的节点
            return this;
        } else if (value < this.value) {//目标节点小于当前节点,往左递归查找
            if (this.left == null) {//如果左子树找完都找不到
                return null;
            }
            return this.left.searchTarget(value);//递归一直找
        } else {//目标节点大于等于当前节点,往右递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.searchTarget(value);
        }
    }

    //查找要删除的目标节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {//当前节点是要查找的节点的父节点
            return this;
        } else {//当前节点不是要查找的节点的父节点
            if (value < this.value && this.left != null) {//往左递归查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {//往右递归查找
                return this.right.searchParent(value);
            } else {//没有父节点的情况
                return null;
            }
        }
    }
}

