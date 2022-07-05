package com.zyh.zuochengyun.graph;

public class Edge {
    //连接的权值
    public int weight;
    //针对有向图的连接属性
    //from：谁指向我
    //to：我指向谁
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
