package com.zyh.hsp_datastructure.datastructure;

/**
 * * 普通二叉查找树会面临：一个父节点的左子树和右子树高度相差很大,这时二叉查找树类似于单链表,性能会受到影响
 * * 改进普通二叉查找树为平衡二叉树
 * <p>
 * 平衡二叉树
 * AVL树本质上还是一棵二叉搜索树，它的特点是：
 * 1.本身首先是一棵二叉搜索树
 * 2.带有平衡条件：每个结点的左右子树的高度之差的绝对值（平衡因子）最多为1
 * 也就是说，AVL树，本质上是带了平衡功能的二叉查找树（二叉排序树，二叉搜索树）
 * <p>
 * 在对平衡二叉树进行插入和删除的操作时,可能会破坏原有的平衡,可以通过旋转来保持平衡
 * 单旋转：
 * 左旋转：右子树高度高于左子树高度(高度差大于1),左旋转来降低右子树的高度
 * 右旋转：左子树高度大于右子树高度(高度差大于1),右旋转来降低左子树高度
 * 双旋转：
 * 左右旋转
 * 右转旋转
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, -10, -1, 5, 6};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLNode(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());


    }

}

class AVLTree {



    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }

    public void infixOrder() {
        if (root == null) {
            return;
        } else {
            root.infixOrder();
        }
    }

    public AVLNode searchTarget(int value) {
        if (root != null) {
            return root.searchTarget(value);
        } else {
            return null;
        }
    }

    public AVLNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void delete(int value) {
        //1.删除的节点是叶子节点
        //2.删除的节点只有一个子树（左或者右）
        //3.删除的节点有两个子树（左和右）
        AVLNode target = searchTarget(value);//要删除的目标节点（可能为null）
        AVLNode parent = searchParent(value);//要删除的节点的父节点（可能为null）

        if (target != null) {//找到了要删除的节点
            if (target.getLeft() == null && target.getRight() == null) {//1.target是叶子节点
                if (parent == null) {//target是叶子节点,而且是根节点
                    root = null;
                } else {//target是叶子节点,而且有父节点
                    if (parent.getLeft() == target) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }
            }
            //2.target只有一个子树（左或者右）
            //2.1.target只有左子树
            else if (target.getLeft() != null && target.getRight() == null) {
                if (parent == null) {//target是只有一个左子树的根节点
                    root = target.getLeft();
                } else {//target不是根节点但只有一个左子树
                    if (parent.getLeft() == target) {//target是左子树
                        parent.setLeft(target.getLeft());
                    } else {//target是右子树
                        parent.setRight(target.getLeft());
                    }
                }
            }
            //2.2.target只有右子树
            else if (target.getRight() != null && target.getLeft() == null) {
                if (parent == null) {//target是只有一个右子树的根节点
                    root = target.getRight();
                } else {//target不是根节点但只有一个右子树
                    if (parent.getLeft() == target) {//target是左子树
                        parent.setLeft(target.getRight());
                    } else {//target是右子树
                        parent.setRight(target.getRight());
                    }
                }
            }
            //3.target有两个子树
            else {
                //3.1.在左子树找最大的（往右子树找）
                //3.2.或者在右子树里找最小的（往左子树找）
                int min = delRightTreeMin(target.getRight());
                target.setValue(min);
            }
        } else {
            System.out.println("没找到要删除的节点");
        }
    }

    /**
     * 右子树里找最小的,得往左子树方向找
     *
     * @param node 右子节点
     * @return
     */
    public int delRightTreeMin(AVLNode node) {
        AVLNode target = node;//记录右子树的最小节点
        while (target.getLeft() != null) {//往左子树方向找,因为左边才有小的
            target = target.getLeft();
        }//找到最小的
        delete(target.getValue());//把最小节点删掉（因为要放到前面）

        return target.getValue();//最小节点的值保留,为了放到删除之后的空位上
    }

    /**
     * 左子树里找最大的（得往右子树方向找）
     *
     * @param node 左子节点
     * @return
     */
    public int delLeftTreeMax(AVLNode node) {
        AVLNode target = node;//记录左子树最大节点
        while (target.getRight() != null) {
            target = target.getRight();
        }
        delete(target.getValue());
        return target.getValue();
    }


    public void add(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
}

class AVLNode {

    public int value;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "AVLNode [value=" + value + "]";
    }


    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }

    }


    //左旋转

    //右旋转

    //以当前节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左子树高度
    public int leftHeight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.height();
        }
    }

    //右子树高度
    public int rightHeight() {
        if (this.right == null) {
            return 0;
        } else {
            return this.right.height();
        }
    }

    //添加,AVL树平衡可能会打破,要进行旋转判断
    //LL：当前节点的左子树的左子树
    //RR：
    //LR
    //RL
    public void add(AVLNode node) {
        //添加的节点比当前节点小,放到左边
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {//添加的节点大于等于当前节点,放到右边
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        //如果当前节点target的：左子树高度-右子树高度 > 1,右旋转降低左子树高度
        //此外如果当前节点target的左子树(target.left)
        // ,它的右子树高度还比当它的左子树高度高,那么要先对这个左节点进行左旋转,再对当前节点进行右旋转
        if (leftHeight() - rightHeight() > 1) {//LL
            if (left != null && left.rightHeight() > left.leftHeight()) {//LR
                left.leftRotate();
            }
            rightRotate();
        }
        //如果当前节点target的：右子树高度-左子树高度 > 1,左旋转降低右子树高度
        //此外如果当前节点target的右子树(target.right)
        // ,它的左子树高度还比它的右子树高度高,那么要先对这个右子节点进行右旋转,再对当前节点进行左旋转
        if (rightHeight() - leftHeight() > 1) {//RR
            if (right != null && right.leftHeight() > right.rightHeight()) {//RL
                right.rightRotate();
            }
            leftRotate();
        }


    }

    //左旋转
    private void leftRotate() {
        AVLNode newNode = new AVLNode(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = newNode;

    }

    //右旋转
    public void rightRotate() {
        AVLNode newNode = new AVLNode(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }


    public AVLNode searchTarget(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.searchTarget(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.searchTarget(value);
        }
    }

    public AVLNode searchParent(int value) {
        if (this.left != null && this.left.value == value
                || this.right != null && this.right.value == value) {//当前节点的左子节点或者右子节点是要查找的节点（当前节点是要查找的节点的父节点）
            return this;
        } else {//当前节点不是要查找的节点的父节点
            if (this.left != null && value < this.value) {//要查找的节点比当前节点小,往左递归查找
                return this.left.searchParent(value);
            } else if (this.right != null && value >= this.value) {//要查找的节点比当前节点大,往右递归查找
                return this.right.searchParent(value);
            } else {//左右递归都没找到,即没找到该节点的父节点
                return null;
            }
        }
    }
}
