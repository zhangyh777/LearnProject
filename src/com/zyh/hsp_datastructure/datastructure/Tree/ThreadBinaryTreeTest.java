package com.zyh.hsp_datastructure.datastructure.Tree;

/**
 * 线索化二叉树（又分为前序线索二叉树,中序线索二叉树,后序线索二叉树）
 *  * 前驱节点 节点A的前一个节点
 *  * 后继节点 节点A的后一个节点
 * 一般二叉树的叶子结点的左右子结点都指向空，指针没有充分利用
 * 线索化后，叶子结点的左子结点指向的是“前驱结点”，叶子结点的右子结点指向的是“后继结点”
 * <p>
 * 双向指针，线索化二叉树不仅可以直接访问它的下一个节点,也可以直接访问它的上一个节点,
 * 和链式二叉树或者顺序二叉树的区别类似于单向链表和双向链表的区别
 * <p>
 * n个节点得二叉树中，含有n+1个空指针域，
 * 利用该节点的空指针域，存放指向该节点在某种遍历次序下的前驱和后继节点的指针
 * <p>
 * 线索化二叉树后,节点的left和right指针发生变化
 * left 可能指向左子树，也可能指向前驱节点
 * right 可能指向右子树，也可能指向后继节点
 */
public class ThreadBinaryTreeTest {
    public static void main(String[] args) {
        EmployeeNode root = new EmployeeNode(1, "a");
        EmployeeNode node2 = new EmployeeNode(2, "b");
        EmployeeNode node3 = new EmployeeNode(3, "c");
        EmployeeNode node4 = new EmployeeNode(4, "d");
        EmployeeNode node5 = new EmployeeNode(5, "e");
        EmployeeNode node6 = new EmployeeNode(6, "f");
        EmployeeNode node7 = new EmployeeNode(7, "g");
        EmployeeNode node8 = new EmployeeNode(8, "h");
        EmployeeNode node9 = new EmployeeNode(9, "i");
        //创建二叉树
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        //给二叉树分配节点
        /*
                                   1
                       2                       3
                  4         5              6           7
             8                        9
         */
        threadBinaryTree.setRoot(root);
        root.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setLeft(node8);

        root.setRight(node3);
        node3.setLeft(node6);
        node6.setLeft(node9);
        node3.setRight(node7);

        threadBinaryTree.infixThreadTree();
        threadBinaryTree.infixShowThreadTree();
        System.out.println("=============");
        System.out.println(node4.right);//node2
        System.out.println(node9.left);//node1
        System.out.println(node2.rightType);//0

//        System.out.println("=============");
//        threadBinaryTree.preThreadTree(root);
//        threadBinaryTree.preShowThreadTree();



    }
}


//线索化二叉树
class ThreadBinaryTree {
    public EmployeeNode root;//根节点
    public EmployeeNode pre = null;//临时节点代表当前节点的前一个结点

    public EmployeeNode getRoot() {
        return root;
    }

    public void setRoot(EmployeeNode root) {
        this.root = root;
    }

    public void infixThreadTree() {
        infixThreadTree(root);
    }
    /** 中序线索化
     * @param node 要线索化的节点
     */
    public void infixThreadTree(EmployeeNode node) {
        if (node == null) {
            return;
        }

        //左子树线索化
        infixThreadTree(node.left);

        //当前节点线索化
        //处理当前节点的前驱节点
        if (node.left == null) {//当前节点左指针为空
            node.left = pre;//把当前节点左指针指向前驱节点
            node.leftType = 1;//当前节点的左指针Type设为前驱节点类型
        }
        //处理当前节点的后继节点
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        //！！！！！！
        pre = node;


        //右子树线索化
        infixThreadTree(node.right);
    }

    //中序遍历线索二叉树
    public void infixShowThreadTree() {
        EmployeeNode node = root;

        while (node != null) {

            while (node.leftType == 0) {//当前节点的left指针类型为子树的话就继续往下找,直到left指针类型为节点才停止查找
                                        //当前节点的left指针类型为前驱节点的话,就是说找到左子树这边的叶子节点处了
                node = node.left;
            }//while循环结束的话,此时node节点为左半部的叶子节点,从这里开始中序遍历线索二叉树
            System.out.println(node);

            while (node.rightType == 1) {//当前节点的right指针类型为后继节点就继续往下走并打印该节点
                node = node.right;
                System.out.println(node);
            }//while循环结束之后,此时的node节点的right指针类型为0,是子树
            node = node.right;
        }
    }


    //前序线索化二叉树
    public void preThreadTree(EmployeeNode node) {
        if (node == null) {//空树
            return;
        }

        //线索化当前节点

        //处理当前节点的前驱节点
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        //处理当前节点的后继节点
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;


        //左子树线索化
        //如果当前节点的left指针类型是子树的话就继续递归，直到当前节点的left指针是前驱节点才停止
        if (node.leftType == 0) {
            preThreadTree(node.left);
        }

        //右子树线索化
        //如果当前节点的right指针类型是子树的话就继续递归，直到当前节点的right指针类型是后继节点为止
        if (node.rightType ==0) {
            preThreadTree(node.right);
        }
    }

    //前序遍历线索化二叉树
    public void preShowThreadTree() {
        EmployeeNode node = root;

        while (node != null) {
            System.out.println(node);
            if (node.leftType == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    //后序线索化二叉树
    public void postThreadTree(EmployeeNode node) {

    }

    //后序遍历线索化二叉树
    public void postShowThreadTree() {
    }


    /*
        如果要删除的节点是非叶子节点
        1.如果该非叶子节点只有一个子节点（左或右）,用该子节点替换删除的节点
        2.如果该非叶子节点既有左节点又有右节点,那么用左节点替换删除的节点
     */
    public void delete(int id) {
        if (root != null) {
            if (root.getId() == id) {
                root = null;
            } else {
                root.delete(id);
            }
        } else {
            System.out.println("空树,无法删除");
        }
    }

    //删除节点
    public void del(int id) {
        //1.
        if (root != null) {//树不为空的话
            if (root.getId() == id) {//如果根节点就是要删除的节点
                root = null;
            } else {//如果根节点不是要删除的节点的话
                root.del(id);
            }
        } else {//空树的情况
            System.out.println("空树,不能删除");
        }

    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }

    }

    //前序查找
    public EmployeeNode preSearch(int id) {
        if (root != null) {
            return root.preSearch(id);
        } else {
            return null;
        }
    }

    //中序查找
    public EmployeeNode infixSearch(int id) {
        if (root != null) {
            return root.infixSearch(id);
        } else {
            return null;
        }
    }

    //后序查找
    public EmployeeNode postSearch(int id) {
        if (root != null) {
            return root.postSearch(id);
        } else {
            return null;
        }
    }

}

class EmployeeNode {
    //属性
    public int id;
    public String name;

    public EmployeeNode left;//左指针
    public EmployeeNode right;//右指针
    //左指针的种类标志（0表示指向左子树,1表示指向前驱节点）
    public int leftType;
    //右指针的种类标志（0表示指向右子树,1表示指向后继节点）
    public int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeNode getLeft() {
        return left;
    }

    public EmployeeNode getRight() {
        return right;
    }

    public void setLeft(EmployeeNode left) {
        this.left = left;
    }

    public void setRight(EmployeeNode right) {
        this.right = right;
    }

    public EmployeeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return ("id= " + id + ",name= " + name);
    }


    /*
        1.如果是空树,提示不能删除;如果不是空树但要删除的节点就是根节点,直接root=null
        否则：
        因为二叉树是单向结构,所以删除节点的话,要看当前节点的后面的节点(左子节点或者右子节点)是否是要删除的节点
        如果直接看当前节点是否是要删除的节点的话,就算当前节点确实是要删除的节点,但它的父节点已经无法获取到了,也就没法重新定义要删除的节点的父节点的左右指向
        2.如果当前节点的左子节点不为空并且该左子节点就是要删除的节点,将该子节点置空,
        3.如果当前节点的右子节点不为空并且该右子节点就是要删除的节点,将该子节点置空
        4.2和3都没有删除节点的话就对左子树递归继续查找
        5.4没有删除节点的话就对右子树递归继续查找
     */
    //如果删除的节点是非叶子节点,该方法会把该节点后面的子树整个删除
    public void del(int id) {
        //2.如果当前节点的左子节点不为空并且左子节点就是要删除的节点,将该左子节点置空
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        //3.如果当前节点的右子节点不为空并且右子节点就是要删除的节点,将该右子节点置空
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        //4.当前节点的左子节点和右子节点都没有找到要删除的节点,先在左子树递归查找
        if (this.left != null) {
            this.left.del(id);
        }//5.当前节点的左子树递归完了也没找到要删除的节点的话,就到右子树递归查找
        if (this.right != null) {
            this.right.del(id);
        }
    }

    /*
        扩展：
        如果要删除的节点是非叶子节点
        1.如果该非叶子节点只有一个子节点（左或右）,用该子节点替换删除的节点
        2.如果该非叶子节点既有左节点又有右节点,那么用左节点替换删除的节点
     */
    public void delete(int id) {
        //当前节点的左子节点是要删除的节点
        if (this.left != null && this.left.id == id) {//this.left是要删除的节点,this就是前一个结点
            EmployeeNode target = this.left;

            if (target.left == null && target.right == null) {//要删除的节点是叶子节点
                this.left = null;
                return;
            } else if (target.left != null && target.right == null) {//要删除的节点不是叶子节点但只有一个左子节点
                EmployeeNode temp = target.left;
                this.left = temp;
                return;
            } else if (target.right != null && target.left == null) {//要删除的节点不是叶子节点只有一个右子节点
                EmployeeNode temp = target.right;
                this.left = temp;
                return;
            } else if (target.left != null && target.right != null) {//要删除的节点既有左子节点又有右子节点
                //左子节点替换待删除结点
                EmployeeNode temp = target.left;
                this.left = temp;
                temp.left = target.right;
            }
        }
        //当前节点的右子节点是要删除的节点
        if (this.right != null && this.right.id == id) {//this.right就是要删除的节点
            EmployeeNode target = this.right;

            if (target.left == null && target.right == null) {//要删除的节点是叶子节点
                this.left = null;
                return;
            } else if (target.left != null && target.right == null) {//要删除的节点不是叶子节点但只有左子节点
                EmployeeNode temp = target.left;
                this.right = temp;
                return;
            } else if (target.right != null && target.left == null) {//要删除的节点不是叶子节点但只有右子节点
                EmployeeNode temp = target.right;
                this.right = target.right;
                return;
            } else if (target.left != null && target.right != null) {//要删除的节点既有左子节点又有右子节点
                //左子节点代替要删除的节点
                EmployeeNode temp = target.left;
                this.right = temp;
                temp.right = target.right;
            }
        }


        if (this.left != null) {
            this.left.delete(id);
        }
        if (this.right != null) {
            this.right.delete(id);
        }


    }

    //前序遍历
    public void preOrder() {

        System.out.println(this);
        //左子节点不为空,递归左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //右子节点不为空,递归右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {

        //左子节点不为空,递归左子树
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        //右子节点不为空,递归右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {

        //左子节点不为空,递归左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        //右子节点不为空,递归右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public EmployeeNode preSearch(int id) {

        if (this.id == id) {//当前节点id和要查找的id相等,即找到了,就直接返回当前节点
            return this;
        }
        EmployeeNode res = null;
        if (this.left != null) {//当前节点的左子节点不为空,左递归继续查找
            //找得到的话res就是结果,找不到的话res为null
            res = this.left.preSearch(id);
        }
        if (res != null) {//左子树结束之前找到了
            return res;
        }

        if (this.right != null) {//当前节点的右子节点不为空,右递归继续查找
            //找到了res就是具体的节点,找不到的话就是null
            res = this.right.preSearch(id);
        }
        return res;
    }

    //中序遍历查找
    public EmployeeNode infixSearch(int id) {
        EmployeeNode res = null;
        if (this.left != null) {//当前节点的左子节点不为空,左递归继续查找
            res = this.left.infixSearch(id);
        }

        if (res != null) {//左子树结束之前找到了
            return res;
        }

        if (this.id == id) {//当前节点id和要查找的id相等,即找到了,就直接返回当前节点
            return this;
        }


        if (this.right != null) {//当前节点的右子节点不为空,右递归继续查找
            //找到了res就是具体的节点,找不到的话就是null
            res = this.right.infixSearch(id);
        }
        return res;
    }

    //后序遍历查找
    public EmployeeNode postSearch(int id) {
        EmployeeNode res = null;
        if (this.left != null) {//当前节点的左子节点不为空,左递归继续查找
            res = this.left.postSearch(id);
        }
        if (res != null) {//左子树结束之前找到了
            return res;
        }

        if (this.right != null) {//当前节点的右子节点不为空,右递归继续查找
            //找到了res就是具体的节点,找不到的话就是null
            res = this.right.postSearch(id);
        }
        if (res != null) {
            return res;
        }


        if (this.id == id) {//当前节点id和要查找的id相等,即找到了,就直接返回当前节点
            return this;
        }

        return res;
    }
}

