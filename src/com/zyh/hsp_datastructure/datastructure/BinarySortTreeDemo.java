package com.zyh.hsp_datastructure.datastructure;

/**
 * 二叉排序树
 * 左子节点都比父节点小,右子节点都比父节点大
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 2, 4, 6, 1, 8, 9, 3, 5};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历排序二叉树：");
        binarySortTree.infixOrder();
        Node node = binarySortTree.searchParent(5);
        System.out.println(node);
        System.out.println("=======");
        binarySortTree.delete(10);
        binarySortTree.delete(7);

        binarySortTree.infixOrder();

    }
}

class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void infixOrder() {
        if (root == null) {
            return;
        } else {
            root.infixOrder();
        }
    }

    public Node searchTarget(int value) {
        if (root != null) {
            return root.searchTarget(value);
        } else {
            return null;
        }
    }

    public Node searchParent(int value) {
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
        Node target = searchTarget(value);//要删除的目标节点（可能为null）
        Node parent = searchParent(value);//要删除的节点的父节点（可能为null）

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
                    }else {//target是右子树
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
     * @param node  右子节点
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;//记录右子树的最小节点
        while (target.getLeft() != null) {//往左子树方向找,因为左边才有小的
            target = target.getLeft();
        }//找到最小的
        delete(target.getValue());//把最小节点删掉（因为要放到前面）

        return target.getValue();//最小节点的值保留,为了放到删除之后的空位上
    }

    /**
     * 左子树里找最大的（得往右子树方向找）
     * @param node  左子节点
     * @return
     */
    public int delLeftTreeMax(Node node){
        Node target = node;//记录左子树最大节点
        while (target.getRight()!=null){
            target = target.getRight();
        }
        delete(target.getValue());
        return target.getValue();
    }


    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }


}

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
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

    //添加
    public void add(Node node) {
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


    }


    public Node searchTarget(int value) {
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

    public Node searchParent(int value) {
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
