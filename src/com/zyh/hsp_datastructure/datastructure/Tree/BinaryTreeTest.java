package com.zyh.hsp_datastructure.datastructure.Tree;

import java.util.*;

/**
 * 二叉树：树的每个节点最多只能有两个子节点
 * 满二叉树：除了叶子节点外，别的节点都有两个子节点（节点总个数为 2^n-1）
 * 完全二叉树：1.去掉最后一层节点后为满二叉树
 * 2.最后一层节点从左到右连续（节点总个数为 ）
 * <p>
 * <p>
 * 二叉搜索树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值,
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值,
 * 它的左、右子树也分别为二叉排序树。
 * <p>
 * 遍历树
 * 遍历树是根据一种特定的顺序访问树的每一个节点。比较常用的有前序遍历，中序遍历和后序遍历。而二叉搜索树最常用的是中序遍历
 * 前序遍历二叉树：父节点,左子树,右子树
 * 中序遍历二叉树：左子树,父节点,右子树
 * 后序遍历二叉树：左子树,右子树,父节点
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        Node head = new Node(1, "f");
        Node node2 = new Node(2, "a");
        Node node3 = new Node(3, "b");
        Node node4 = new Node(4, "c");
        Node node5 = new Node(5, "d");
        Node node6 = new Node(6, "e");
        Node node7 = new Node(7, "g");


        //创建二叉树
        LinkedBinaryTree binaryTree = new LinkedBinaryTree();
        binaryTree.setRoot(head);
        head.setLeft(node2);
        head.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);


        System.out.println("前序二叉树");
        binaryTree.preOrder(head);
        System.out.println("====");
        System.out.println("中序二叉树");
        binaryTree.infixOrder(head);
        System.out.println("====");

        System.out.println("后序二叉树");
        binaryTree.postOrder(head);
        System.out.println("====");
        System.out.println(binaryTree.bfs(head));

//        binaryTree.delete(3);
//        System.out.println("删除节点3之后");
//        binaryTree.preOrder(head);
//
//        binaryTree.delete(8);
//        System.out.println("删除节点8之后");
//        binaryTree.preOrder(head);

    }
}


//链式存储二叉树
class LinkedBinaryTree {
    private Node head;//根节点

    public Node getRoot() {
        return head;
    }

    public void setRoot(Node head) {
        this.head = head;
    }

    /*
        如果要删除的节点是非叶子节点
        1.如果该非叶子节点只有一个子节点（左或右）,用该子节点替换删除的节点
        2.如果该非叶子节点既有左节点又有右节点,那么用左节点替换删除的节点
     */
    public void delete(int id) {
        if (head != null) {
            if (head.getId() == id) {
                head = null;
            } else {
                head.delete(id);
            }
        } else {
            System.out.println("空树,无法删除");
        }
    }

    //删除节点
    public void del(int id) {
        if (head != null) {//树不为空的话
            if (head.getId() == id) {//如果根节点就是要删除的节点
                head = null;
            } else {//如果根节点不是要删除的节点的话
                head.del(id);
            }
        } else {//空树的情况
            System.out.println("空树,不能删除");
        }

    }

    //前序遍历（递归）
    public void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head);
        preOrder(head.getLeft());
        preOrder(head.getRight());
    }

    //前序遍历（非递归）
    //1.根节点入栈
    //2.如果栈不为空（while(!stack.isEmpty()){...}）
    //  2.1.节点出栈,处理（打印或者存入数组...）
    //  2.2.先压右子节点(如果有),再压左子节点(如果有)
    public void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head);

                //因为是栈结构先进后出,遍历时是先左后右,入栈时就要先右后左
                if (head.getRight() != null) {
                    stack.push(head.getRight());
                }
                if (head.getLeft() != null) {
                    stack.push(head.getLeft());
                }
            }
        }
        System.out.println();
    }

    //中序遍历（递归）
    public void infixOrder(Node head) {
        if (head == null) {
            return;
        }
        infixOrder(head.getLeft());
        System.out.println(head);
        infixOrder(head.getRight());
    }

    //中序遍历（非递归）
    public void infixOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {//揪着一个节点一直往下找左子节点,入栈,直到节点为空为止
                    stack.push(head);
                    head = head.getLeft();//找当前节点的左子节点,设为新的当前节点
                } else {
                    //节点出栈,处理（打印或者存入数组）
                    head = stack.pop();
                    System.out.println(head);
                    //当前节点变为当前节点的右子节点,重复进行上面的操作
                    head = head.getRight();
                }
            }
        }
        System.out.println();
    }

    //后序遍历（递归）
    public void postOrder(Node head) {
        if (head == null) {
            return;
        }
        postOrder(head.getLeft());
        postOrder(head.getRight());
        System.out.println(head);
    }

    //后序遍历（非递归）,两个栈来实现
    public void postOrderUnRecur(Node head) {
        if (head!=null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            //根节点入栈1
            s1.push(head);
            //栈1不为空的话
            while (!s1.isEmpty()){
                head=s1.pop();
                s2.push(head);
                if (head.getLeft()!=null){
                    s2.push(head.getLeft());
                }
                if (head.getRight()!=null){
                    s2.push(head.getRight());
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop());
            }
        }
        System.out.println();
    }

    /**
     * 二叉树的广度优先遍历（层序遍历）
     *
     * @param head
     */
    public List<List<Node>> bfs(Node head) {
        if (head == null) {
            return new ArrayList<>();
        }
        //
        List<List<Node>> res = new ArrayList<>();
        //队列
        Queue<Node> queue = new LinkedList<>();
        //头节点入队
        queue.add(head);
        while (!queue.isEmpty()) {
            //每层的节点个数
            int levenNodes = queue.size();
            List<Node> subList = new ArrayList<>();
            for (int i = 0; i < levenNodes; i++) {
                //节点出队,处理（打印或者存入数组...）
                Node cur = queue.poll();
                subList.add(cur);
                //System.out.println(cur);
                //先放左再放右
                if (cur.getLeft() != null) {
                    queue.add(cur.getLeft());
                }
                if (cur.getRight() != null) {
                    queue.add(cur.getRight());
                }
            }
            res.add(subList);
        }
        return res;
    }

    /**
     * 二叉树的最大宽度
     *
     * @param head
     * @return
     */
    public int maxDepth(Node head) {
        if (head == null) {
            return 0;
        }
        //队列
        Queue<Node> queue = new LinkedList<>();
        //头节点入队
        queue.add(head);
        //Map记录当前节点在第几层
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        //当前层的序号
        int curLevel = 1;
        //当前层的节点总数
        int curLevelNodes = 0;
        //最大宽度
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            //节点出队,处理（打印或者存入数组...）
            Node cur = queue.poll();
            //当前节点所在的层
            int curNodeLevel = levelMap.get(cur);
            //如果当前节点所在的层和当前正在统计节点总数的层是同一层,就统计节点个数
            if (curNodeLevel == curLevel) {
                //节点数++
                curLevelNodes++;
            } else {//如果不是同一层,说明当前正在统计的层的节点都统计完了,更新最大宽度值,要统计的层++变为下一层,要统计的层的节点数置1
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            //先放左再放右
            //节点入队之前要记录它所在的层的序号
            //因为是左右子节点,层数=当前节点层数+1
            if (cur.getLeft() != null) {
                levelMap.put(cur.getLeft(), curNodeLevel + 1);
                queue.add(cur.getLeft());
            }
            if (cur.getRight() != null) {
                levelMap.put(cur.getRight(), curNodeLevel + 1);
                queue.add(cur.getRight());
            }
        }
        return max;
    }


    /**
     * 判断一棵二叉树是否是搜索（排序）二叉树（左右子树都是排序二叉树,整个中序遍历的结果是升序排列的）
     *
     * @param head
     * @return
     */
    public static int preVal = Integer.MIN_VALUE;

    public boolean checkBST(Node head) {
        if (head == null) {
            return true;
        }

        //判断左子树是否是排序二叉树
        boolean isLeftBst = checkBST(head.getLeft());

        if (!isLeftBst) {
            return false;
        }
        if (head.getId() <= preVal) {
            return false;
        } else {
            preVal = head.getId();
        }
        return judgeBST(head.getRight());


    }

    /**
     * 判断二叉树是否是完全二叉树
     *
     * @param head
     * @return
     */
    public boolean judgeCBT(Node head) {
        /*
            使用宽度优先遍历
            1）.如果遍历到一个节点,只有右子节点却没有左子节点,那么一定不是完全二叉树,返回fasle
            2）.满足1）的情况下,如果遍历到的节点只有一个子节点（左或者右）
                ,那么此后再遍历到的节点全部是叶子节点才能是完全二叉树,否则不是
         */

        if (head == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        //叶子结点的标记
        boolean leaf = false;
        //左右子节点的指针
        Node l = null;
        Node r = null;

        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.getLeft();
            r = head.getRight();
            if (
                    (leaf && !(l == null && r == null))//
                            ||
                            (l == null && r != null)//当前节点只有右子节点但没有左子节点

            ) {
                return false;
            }

            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            //对叶子节点进行标记
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    /**
     * <p>固定套路判断二叉树是否是平衡二叉树，完全二叉树，搜索二叉树</p>
     * 判断二叉树是否是平衡二叉树
     * <p>1.左子树都是平衡二叉树</p>
     * <p>2.右子树都是平衡二叉树</p>
     * <p>3.任意一个节点的左右子树高度差<=1</p>
     *
     * @param head
     * @return
     */
    public boolean judgeBalanced(Node head) {
        return processBalanced(head).isBlanced;
    }

    public ReturnType processBalanced(Node x) {
        if (x == null) {//base case 空树的情况：是平衡二叉树,高度为0
            return new ReturnType(true, 0);
        }

        //递归
        //左右子节点都能拿到两个信息：1.是否是平衡二叉树,2.二叉树的高度
        ReturnType leftData = processBalanced(x.getLeft());
        ReturnType rightData = processBalanced(x.getRight());

        int height = Math.max(leftData.height, rightData.height) + 1;
        //平衡树的条件
        //1.左子树是平衡二叉树
        //2.右子树是平衡二叉树
        //3.任意一个根节点的左右子树高度差<=1
        boolean isBlanced = leftData.isBlanced && rightData.isBlanced && (Math.abs(leftData.height) - rightData.height <= 1);
        return new ReturnType(isBlanced, height);

    }

    /**
     * 判断二叉树是否是搜索（排序）二叉树
     * <p>1.左子树是搜索二叉树</p>
     * <p>2.右子树是搜索二叉树</p>
     * <p>3.左子树最大值<它根节点的值</p>
     * <p>4.右子树的最小值>它根结点的值</p>
     * 因为递归要用到上一次的信息,因此返回值封装的信息要一样,所以封装三个信息：1.子树是否是搜索二叉树2.左子树最大值3.右子树最小值
     *
     * @param head
     * @return
     */
    public boolean judgeBST(Node head) {
        return processBST(head).isBST;
    }

    public ReturnType processBST(Node x) {
        if (x == null) {//base case 空树
            return null;
        }

        ReturnType leftData = processBST(x.getLeft());
        ReturnType rightData = processBST(x.getRight());

        boolean isBST = true;
        int max = x.value;
        int min = x.value;

        //左子树的最小值和根节点比较
        if (leftData != null) {
            min = Math.min(min, leftData.min);
        }
        //右子树最大值和根节点比较
        if (rightData != null) {
            max = Math.max(max, rightData.max);
        }

        //如果左子树返回值不为空并且（左子树不是二叉搜索树 或者 左子树最大值大于等于该左子树的根节点的值）,那么就不是二叉搜索树
        if (leftData != null && (!leftData.isBST || leftData.max >= x.value)) {
            isBST = false;
        }
        //如果右子树返回值不为空并且（右子树不是二叉搜索树 或者 右子树最小值小于等于该右子树的根结点的值）,那么就不是二叉搜索树
        if (rightData != null && (!rightData.isBST || rightData.min <= x.value)) {
            isBST = false;
        }
        return new ReturnType(isBST, max, min);


    }

    /**
     * 判断二叉树是否是满二叉树
     * <p>1.节点总个数num,二叉树高度height,满足num=height^2-1</p>
     *
     * @return
     */
    public boolean judgeFBT(Node head) {
        if (head == null) {
            return true;
        }
        ReturnType data = processFBT(head);
        //节点个数num,二叉树高度height
        //num = height^2 - 1 的话就是满二叉树
        return data.num == (1 << data.height - 1);
    }

    public ReturnType processFBT(Node x) {
        if (x == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = processFBT(x.getLeft());
        ReturnType rightData = processFBT(x.getRight());

        int height = Math.max(leftData.height, rightData.height) + 1;
        int num = leftData.num + rightData.num + 1;
        return new ReturnType(height, num);

    }


    /**
     * 给出二叉树根节点和树中的两个子节点p和q,找出这两个子节点最近的公共父节点
     *
     * @param head 根节点
     * @param p    子节点1
     * @param q    子节点2
     * @return
     */
    public Node lowestCommonParentA(Node head, Node p, Node q) {
        /*
            方式1：哈希表，回溯
            因为p和q在一棵二叉树上，所以肯定会有公共父节点（公共父节点是 1.根节点或者2.二叉树某个节点）
            用哈希表的键值对存放 子节点-父节点，这样就能从子节点定位到其父节点
            从p节点开始遍历，把它的父节点存放到HashSet中
            根节点也要放到HashSet中
            再从q节点开始遍历，看它的父节点是否在HashSet中，如果在的话那么这个父节点就是p和q最近的公共父节点
         */

        //key:子节点,value:父节点
        //可以通过HashMap定位到某个子节点的父节点
        Map<Node, Node> fatherMap = new HashMap<>();
        //根节点的父节点还是根节点
        fatherMap.put(head, head);
        //根节点开始获取每个 子节点-父节点 键值对
        getParent(head, fatherMap);
        //HashSet存放遍历到的父节点
        Set<Node> set = new HashSet<>();
        //从p节点所在的子树开始遍历
        Node cur = p;
        //如果当前节点和它的父节点不相等,说明这个节点不是根节点,添加到HashSet中,再从它的父节点往回找
        while (cur != fatherMap.get(cur)) {
            set.add(cur);
            cur = fatherMap.get(cur);
        }//while循环走完cur节点定位到根节点,但根节点还没加入到HashSet中
        set.add(head);

        //从q节点所在的子树开始遍历
        //如果遍历到的节点在之前的HashSet中,那么该结点就是p和q的最近公共父节点
        cur = q;
        while (!set.contains(cur)) {
            cur = fatherMap.get(cur);
        }
        return cur;
    }

    /**
     * 子节点-父节点 键值对放到HashMap中
     *
     * @param head
     * @param fatherMap 哈希表，键值对存放的是节点和该节点的父节点
     */
    public void getParent(Node head, Map<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        //左（右）节点,左（右）节点的父节点
        fatherMap.put(head.getLeft(), head);
        fatherMap.put(head.getRight(), head);
        //递归,获取左右子树上每个节点对应的父节点
        getParent(head.getLeft(), fatherMap);
        getParent(head.getRight(), fatherMap);
    }

    public Node lowestCommonParentB(Node head, Node p, Node q) {
        /*
            方式2：
            一棵二叉树上的两个节点p和q的最近公共父节点只能有两种情况：
            1.p是q的父节点（直接或间接）或者q是p的父节点（直接或间接）
            2.p和q的公共父节点是别的某个节点

         */
        if (head == null || head == p || head == q) {
            return head;
        }
        Node left = lowestCommonParentB(head.getLeft(), p, q);
        Node right = lowestCommonParentB(head.getRight(), p, q);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

    //二叉树序列化与反序列化


    /**
     * 层序遍历的方式序列化二叉树
     * 空节点序列化时用“#”表示,节点之间用“,”隔开
     * @param head
     * @return
     */
    public String serialize(Node head){
        if (head==null){
            return "#";
        }
        Queue<Node> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur==null){
                res.append("#,");
                continue;
            }
            res.append(cur.value+",");
            queue.add(cur.getLeft());
            queue.add(cur.getRight());
        }
        return res.toString();
    }

    /**
     * 由层序遍历得到的字符串反序列化
     * @param str
     * @return
     */
    public Node deserialize(String str){
        if (str=="#"){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        String[] values = str.split(",");
        Node head = new Node(Integer.parseInt(values[0]));
        queue.add(head);
        for (int i = 0; i < values.length; i++) {
            Node cur = queue.poll();
            //如果当前节点不是null
            if (!"#".equals(values[i])){
                Node left = new Node(Integer.parseInt(values[i]));
                cur.setLeft(left);
                queue.add(left);
            }
            if (!"#".equals(values[++i])){
                Node right = new Node(Integer.parseInt(values[i]));
                cur.setRight(right);
                queue.add(right);
            }
        }
        return head;
    }

    /**
     * 前序遍历方式序列化二叉树生成字符串
     * @param head 二叉树根节点
     * @return
     */
    public String serialByPre(Node head) {
        //空节点序列化成"#"
        if (head == null) {
            return "#_";
        }
        //每个节点转换成字符串,以 “_” 结尾
        String res = head.value + "_";
        //递归,左右子树序列化
        res += serialByPre(head.getLeft());
        res += serialByPre(head.getRight());
        return res;
    }

    /**
     * 通过二叉树序列化得到的字符串反序列化得到二叉树
     * @param preStr
     * @return
     */
    public Node reconByPreString(String preStr) {
        //String数组存放每个节点对应的字符串
        String[] values = preStr.split("_");
        //把节点放到队列中（先进先出）
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }

    /**
     * 通过存储序列化后结点字符串的队列恢复二叉树
     * @param queue
     * @return
     */
    public Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.setLeft(reconPreOrder(queue));
        head.setRight(reconPreOrder(queue));
        return head;
    }


}

//返回值类,封装了多个返回值
class ReturnType {
    public boolean isBlanced;
    public int height;

    public ReturnType(boolean isBlanced, int height) {
        this.isBlanced = isBlanced;
        this.height = height;
    }

    public boolean isBST;
    public int max;
    public int min;

    public ReturnType(boolean isBST, int max, int min) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }

    public int num;

    public ReturnType(int height, int num) {
        this.height = height;
        this.num = num;
    }
}


//节点
class Node {
    //属性
    private int id;
    private String name;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    private Node left;//左子节点
    private Node right;//右子节点

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

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int id, String name) {
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
            Node target = this.left;

            if (target.left == null && target.right == null) {//要删除的节点是叶子节点
                this.left = null;
                return;
            } else if (target.left != null && target.right == null) {//要删除的节点不是叶子节点但只有一个左子节点
                Node temp = target.left;
                this.left = temp;
                return;
            } else if (target.right != null && target.left == null) {//要删除的节点不是叶子节点只有一个右子节点
                Node temp = target.right;
                this.left = temp;
                return;
            } else if (target.left != null && target.right != null) {//要删除的节点既有左子节点又有右子节点
                //左子节点替换待删除结点
                Node temp = target.left;
                this.left = temp;
                temp.left = target.right;
            }
        }
        //当前节点的右子节点是要删除的节点
        if (this.right != null && this.right.id == id) {//this.right就是要删除的节点
            Node target = this.right;

            if (target.left == null && target.right == null) {//要删除的节点是叶子节点
                this.left = null;
                return;
            } else if (target.left != null && target.right == null) {//要删除的节点不是叶子节点但只有左子节点
                Node temp = target.left;
                this.right = temp;
                return;
            } else if (target.right != null && target.left == null) {//要删除的节点不是叶子节点但只有右子节点
                Node temp = target.right;
                this.right = target.right;
                return;
            } else if (target.left != null && target.right != null) {//要删除的节点既有左子节点又有右子节点
                //左子节点代替要删除的节点
                Node temp = target.left;
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


}
