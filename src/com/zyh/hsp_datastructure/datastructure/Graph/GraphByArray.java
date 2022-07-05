package com.zyh.hsp_datastructure.datastructure.Graph;

import com.zyh.hsp_datastructure.datastructure.Queue_.ArrayQueue.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *            A
 *          /  \
 *         /    \
 *        B      D
 *       /  \    /|
 *      /    \  / |
 *     /      C   |
 *    /        \  |
 *   E—————————— F
 *
 *
 *
 */
public class GraphByArray {
    public static void main(String[] args) {
        String[] Vertexs = {"A", "B", "C", "D", "E", "F"};
        Graph graph = new Graph(Vertexs);
        graph.link(0, 1, 1);//A-B
        graph.link(0, 3, 1);//A-D
        graph.link(1, 2, 1);//B-C
        graph.link(1, 4, 1);//B-E
        graph.link(2, 3, 1);//C-D
        graph.link(2, 5, 1);//C-F
        graph.link(4, 5, 1);//E-F
        graph.link(3, 5, 1);//D-F


        System.out.println(graph.getNumOfLink());
        for (int i = 0; i < graph.getSize(); i++) {
            System.out.println(graph.getVertexs(i));
        }
        System.out.println(graph.getLinkedStatus(0, 1));
        graph.showGraph();
        System.out.println("深度优先遍历图：");
        graph.dfs();//ABCDFE
        System.out.println();
        graph.bfs();//ABDCEF
    }
}

class Graph {

    //存放图的节点名称
    private ArrayList<String> Vertexs;
    //存放节点之间的连接关系,1代表连接,0代表无连接
    private int[][] graphByArray;
    //所有节点的连接总数
    private int numOfLink;


    public Graph(String[] arr) {
        Vertexs = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            Vertexs.add(arr[i]);
        }
        graphByArray = new int[arr.length][arr.length];
        numOfLink = 0;

    }

    //获取图的节点名称
    public String getVertexs(int i) {
        return Vertexs.get(i);
    }

    //获取图的节点总数
    public int getSize() {
        return Vertexs.size();
    }

    //获取图的连接个数
    public int getNumOfLink() {
        return numOfLink;
    }

    //获取节点之间的连接状态
    public int getLinkedStatus(int i, int j) {
        return graphByArray[i][j];
    }

    //添加节点
    public void addVertex(String Vertex) {
        Vertexs.add(Vertex);
    }

    /**
     * 创建节点间的连接关系
     *
     * @param vertex1 顶点1
     * @param vertex2 顶点2
     * @param flag    是否连接（1连,0不连）
     */
    public void link(int vertex1, int vertex2, int flag) {
        graphByArray[vertex1][vertex2] = flag;
        graphByArray[vertex2][vertex1] = flag;
        numOfLink++;//节点之间的连接数++
    }

    public void showGraph() {
        for (int i = 0; i < graphByArray.length; i++) {
            System.out.println(Arrays.toString(graphByArray[i]));
        }
    }

    //获取index节点的第一个邻接节点的索引，有的话返回索引，没有的话返回-1
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < Vertexs.size(); i++) {
            if (graphByArray[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     * 两个必须参数：1.叶子节点
     * 2.叶子节点的父节点
     * 在当前节点身上找不到相邻接的节点（走到头撞墙了）,回退一步回到邻接点是它的父节点身上,在这个父节点身上继续找邻接点
     *
     * @param n1 n2的父节点
     * @param n2 撞南墙的点,需要回退到它的父节点
     * @return
     */
    public int getNextNeighbor(int n1, int n2) {
        for (int i = n2 + 1; i < Vertexs.size(); i++) {
            if (graphByArray[n1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /*
    图的深度优先遍历(dfs),不撞南墙不回头,和树的前序遍历类似
    1)访问初始结点v，并标记结点v为已访问
    2),查找结点v的第一个邻接结点w，判断邻接节点w是否存在
    3),若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续
    4),若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）
    5),若w被访问过，查找结点v的邻接结点w的下一个邻接结点，转到步骤3。
     */

    /**
     * @param flag  访问标志数组
     * @param index 访问的结点索引,初始为0
     */
    //从index节点开始深度优先遍历（只针对index这一个节点）
    private void dfs(boolean[] flag, int index) {
        //1.访问index节点
        System.out.print(getVertexs(index));
        //访问标志变为true
        flag[index] = true;
        //2.查找节点的第一个邻接节点（存在的话w=该节点的索引,不存在的话w=-1）
        int w = getFirstNeighbor(index);
        //3.邻接节点存在
        while (w != -1) {
            //4.该邻接节点没有被访问过
            if (!flag[w]) {
                dfs(flag, w);//递归访问
            }
            //5.邻接节点被访问过
            //回到上一个节点,查找这个节点的邻接点
            w = getNextNeighbor(index, w);
        }
    }

    //5.回到3（遍历图的所有节点,对没有遍历过的进行遍历）
    public void dfs() {
        //存储节点是否被访问过
        boolean[] flag = new boolean[getSize()];
        for (int i = 0; i < getSize(); i++) {
            if (!flag[i]) {
                dfs(flag, i);
            }
        }
    }

    /*
        图的广度优先遍历（bfs）,用队列实现（先访问的节点先入队,之后也能先出队去访问它的邻接点）
        先访问头节点v,作标记,入队
        之后访问头结点的所有未访问过的直系邻接节点v1,v2,,,,vt,并作标记,入队
        v的邻接节点都访问完了之后,从之前的队列中出队节点（）,
        依次(因为节点是队列存储的,只需要出队就行,出队顺序就是之前访问的邻接点的顺序)
        访问v的邻接点的邻接点,即v1,,,vt的邻接节点（和访问v的邻接点一样的）

     */
    public void bfs() {
        //访问标志
        boolean[] flag = new boolean[Vertexs.size()];
        //队列
        ArrayQueue queue = new ArrayQueue(Vertexs.size());
        //假定从索引为0的节点开始广度优先遍历,标记,入队
        flag[0] = true;
        queue.enQueue(0);

        System.out.println("广度优先遍历：");
        while (!queue.isEmpty()) {
            //从出队的节点开始遍历它的所有邻接节点
            int index = queue.deQueue();
            //访问当前节点
            System.out.print(Vertexs.get(index));
            //访问它的所有未访问过的邻接节点
            for (int i = 0; i < getSize(); i++) {
                //邻接节点存在并且没有访问过
                if (graphByArray[index][i] != 0 && !flag[i]) {
                    flag[i] = true;//标记
                    queue.enQueue(i);//入队
                }
            }
        }
    }

}
