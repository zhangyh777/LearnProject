package com.zyh.hsp_datastructure.binarysortree;


/**
 * 平衡二叉树,也叫平衡二叉搜索树,
 * 平衡二叉树也是二叉排序树,同时具有另外的特点
 * 特点：空树或者左右两个子树的高度差绝对值不超过1（平衡状态）,并且左右两个子树又都是平衡二叉树
 * 引起结点数量变化的操作才可能导致平衡被改变，也就是删除和插入操作
 * 无论是插入还是删除，只有那些从插入或者删除点到根结点的路径上的结点的平衡才有可能被改变，因为只有这些结点的子树才可能发生变化，所以最终也只需针对这些点进行平衡修复操作即可
 * 恢复平衡：旋转
 * 左子树高度大于右子树高度,且差值大于1：右旋转降低左子树的高度
 *
 * 右子树高度大于左子树高度,且差值大于1：左旋转降低右子树的高度
 *
 * AVL树只是实现平衡二叉树的一种方法，它还有很多的其他实现方法如红黑树、替罪羊树、Treap、伸展树等
 * <p>
 * 二叉排序树,单向,查找很慢
 */
public class AVLTreeTest {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
        int[] arr = {10, 12, 8, 9, 7, 6};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new ND(arr[i]));
        }
        System.out.println("排序二叉树：");
        avlTree.infixOrder();
        System.out.println(avlTree.getRoot().height());//4
        System.out.println(avlTree.getRoot().leftHeight());//1
        System.out.println(avlTree.getRoot().rightHeight());//3


    }
}

class AVLTree {
    public ND root;

    public ND getRoot() {
        return root;
    }

    public void setRoot(ND root) {
        this.root = root;
    }

    public void add(ND node) {
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


    public ND searchTarget(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchTarget(value);
        }
    }

    public ND searchParent(int value) {
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
            ND target = searchTarget(value);//查找要删除的目标节点,要么找到,要么找不到
            ND parent = searchParent(value);//找到要删除的节点的父节点
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

    public int delRightTreeMin(ND node) {
        ND target = node;//记录最小节点
        while (target.left != null) {//往左子树找最小值
            target = target.left;
        }
        delete(target.value);//把最小节点删掉（因为要放到前面）

        return target.value;//最小节点的值保留,为了放到删除之后的空位上
    }

    public int delLeftTreeMax(ND node) {
        ND target = node;
        while (target.right != null) {
            target = target.right;
        }
        delete(target.value);
        return target.value;
    }
}

class ND {
    public int value;
    public ND left;
    public ND right;

    public ND(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ND[value=" + this.value + "]";
    }

    //左旋转,降低右子树的高度
    //1.创建新节点newNode,value为当前根结点的value
    //2.设新节点的左子节点为当前节点的左子树
    //3.设新节点的右子树为当前节点的右子树的左子树
    //4.当前节点的value替换为右子节点的值
    //5.设当前节点的右子树为右子树的右子树
    //6.把当前节点的左子树设为之前新建的新节点
    public void leftRotate() {
        //1.
        ND newNode = new ND(this.value);
        //2.
        newNode.left = this.left;
        //3.
        newNode.right = this.right.left;
        //4.
        this.value = this.right.value;
        //5.
        this.right = this.right.right;
        //6.
        this.left = newNode;

    }

    //右旋转,降低左子树的高度
    //1.创建新节点newNode,value为当前根结点的value
    //2.设新节点的右子节点为当前节点的右子树
    //3.设新节点的左子树为当前节点的左子树的右子树
    //4.当前节点的value替换为左子节点的值
    //5.设当前节点的左子树为左子树的左子树
    //6.把当前节点的右子树设为之前新建的新节点
    public void rightRotate() {
        ND newNode = new ND(value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }


    //计算以当前节点为根节点的树的高度
    public int height() {
        return (Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height())) + 1;
    }

    //左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    //右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }


    //平衡二叉树添加新节点时要考虑是否会打破平衡二叉树的结构
    public void add(ND node) {
        if (node.value < this.value) {//小于当前节点的话
            if (this.left == null) {//当前节点左子节点为空就直接放到左子结点
                this.left = node;
            } else {//左子节点不为空（没有找到大于node的最小节点）就递归往下继续找
                this.left.add(node);
            }
        } else {//大于等于当前节点
            if (this.right == null) {//当前节点右子节点为空就直接放到右子节点
                this.right = node;
            } else {//右子节点不为空（没有找到小于node的最大节点）就递归往下继续找
                this.right.add(node);
            }
        }
        //右子树比左子树高,且高度差大于1,左旋转降低右子树的高度
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树高度大于它的右子树高度
            //先对当前这个节点(右子节点,this.right)进行右旋转
            //再对当前节点(this)进行左旋转
            if (right != null && right.leftHeight() > right.rightHeight()) {//RL
                right.rightRotate();
                leftRotate();
            } else {//RR,否则直接左旋转
                leftRotate();
            }
            //上边的旋转处理完后下边的旋转就没必要了
            return;
        }
        //左子树比右子树高,且高度差大于1,右旋转降低左子树的高度
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树高度
            //先对当前这个节点(this.left)进行左旋转
            //再对当前节点(this)进行右旋转
            if (left != null && left.rightHeight() > left.leftHeight()) {//LR
                left.leftRotate();
                rightRotate();
            } else {//LL,否则直接右旋转
                rightRotate();
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
    public ND searchTarget(int value) {
        if (this.value == value) {//当前节点就是要找的节点
            return this;
        } else if (value < this.value) {//目标节点小于当前节点,往左递归查找
            if (this.left == null) {//如果左子树找完都找不到
                return null;
            }
            return this.left.searchTarget(value);//往左递归一直找
        } else {//目标节点大于等于当前节点,往右递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.searchTarget(value);//往右递归一直找
        }
    }

    //查找要删除的目标节点的父节点
    public ND searchParent(int value) {
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

