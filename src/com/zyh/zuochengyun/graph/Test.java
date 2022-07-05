package com.zyh.zuochengyun.graph;

import java.util.*;

public class Test {
    public static void main(String[] args) {

    }
    /**
     * 由二维数组创建图
     * <p>matrix[i][0]:谁指向当前节点</p>
     * <p>matrix[i][1]:当前结点指向谁</p>
     * <p>matrix[i][2]:两个节点间的权重</p>
     * @param matrix
     * @return
     */
    public static Graph createGraph(int[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; ++i) {
            //父节点
            Integer from = matrix[i][0];
            //子节点
            Integer to = matrix[i][1];
            //连接的权值
            Integer weight = matrix[i][2];

            //
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            //
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }

            //从哈希表里拿到相关节点
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            //创建两个节点的连接
            Edge newEdge = new Edge(weight,fromNode,toNode);
            //子节点添加到（父节点直接指向的子节点的）集合中
            fromNode.nexts.add(toNode);
            //父节点的out++
            fromNode.out++;
            //子节点的in++
            toNode.in++;
            //父节点的边界集合有新的元素
            fromNode.edges.add(newEdge);
            //图的边界集合
            graph.edges.add(newEdge);
        }
        return graph;
    }


    /**
     * 图的宽度优先遍历
     * <p>用队列实现</>
     * @param node
     */
    public static void bfs(Node node){
        if (node==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        //Set用来去重,保证每个节点只遍历一次
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()){
            //当前节点
            Node cur = queue.poll();
            //处理
            System.out.println(cur);
            //当前节点的每个子节点
            for (Node next: cur.nexts
                 ) {
                if (!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }

    }


    /**
     * 图的深度优先遍历,类似于二叉树的前序遍历
     * <p></p>
     */
    public static void dfs(Node node){
        if (node==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);

        System.out.println(node);

        while (!stack.isEmpty()){
            //当前节点
            Node cur = stack.pop();
            //当前节点的每个子节点
            for (Node next:cur.nexts
                 ) {
                if(!set.contains(next)){//如果某个子节点没有遍历过
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next);
                    break;
                }
            }
        }

    }






}
