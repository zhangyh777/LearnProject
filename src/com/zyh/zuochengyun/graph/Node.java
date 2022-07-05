package com.zyh.zuochengyun.graph;

import java.util.ArrayList;

public class Node {
    //图上每个节点的属性
    public int val;
    //每个节点的入度（有多少个节点连接到该点）和出度（该节点连接了多少个节点）
    //有向图和无向图的in和out会有差别
    public int in;
    public int out;
    //存放当前节点直接指向的节点
    public ArrayList<Node> nexts;
    //当前节点属于哪些边（由它自己发散出去的,out）
    public ArrayList<Edge> edges;

    public Node(int val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
