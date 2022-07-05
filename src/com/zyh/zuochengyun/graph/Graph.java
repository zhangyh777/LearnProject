package com.zyh.zuochengyun.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    //key:节点编号,value:节点
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }



}
