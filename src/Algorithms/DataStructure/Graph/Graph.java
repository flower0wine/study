package Algorithms.DataStructure.Graph;

import Algorithms.DataStructure.Queue.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 23 10:47
 *
 * 无向图(底层：矩阵)
 */
public class Graph {
    // 两个节点的边
    private int[][] edges;
    // 顶点
    private ArrayList<String> vertexList;
    // 边的个数
    private int edgeOfNum;

    public Graph(String[] strings) {
        int n = strings.length;
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        List<String> stringList = Arrays.asList(strings);
        vertexList.addAll(stringList);
    }

    public int vertexSize() { // 顶点数
        return vertexList.size();
    }

    public int edgeSize() { // 边数
        return edgeOfNum;
    }

    // 修改边
    public Graph modifyEdge(int v1, int v2, int val) {
        if(v1 > edges.length || v2 > edges[v1].length || edges[v1][v2] == val) return this;
        else if(edges[v1][v2] != val && val == 1) edgeOfNum++;
        else if(edges[v1][v2] != val && val == 0) edgeOfNum--;
        edges[v1][v2] = edges[v2][v1] = val;
        return this;
    }

    // 控制台输出图
    public void depthFirstSearch() {
        boolean[] visited = new boolean[vertexList.size()];
        System.out.println(vertexList.get(0)); // 初始节点先访问
        visited[0] = true;
        depthFirstSearch(0, 0, visited);
    }

    // 深度优先遍历, 在矩阵中是从第一行行首开始找, 如果是未访问过的, 则输出，并从该邻接节点对应的行开始访问, 直至全部访问
    private void depthFirstSearch(int i, int j, boolean[] visited) {
        if(i < edges.length) {
            if(j < edges[i].length) {
                if(edges[i][j] == 1) { // 如果为 1,, 则进入下一行, i + 1, 当下一行完毕后回溯
                    if(!visited[j]) {
                        visited[j] = true;
                        System.out.println(vertexList.get(j));
                    }
                    if(i < edges.length) {
                        // 从该节点对应的行开始访问, 第 j 行
                        depthFirstSearch(j, j + 1, visited);// 注意: 如果是有向图, 此处的 j + 1 应为 0
                    }
                }
                depthFirstSearch(i, j + 1, visited); // 回溯完后执行本行
            }
        }
    }

    // 广度优先搜索, 在矩阵中是从第一行开始, 将除该行节点以外所有未访问过的节点都加入队列, 设置为已访问, 然后从队列第一个开始移除,
    // 从被移除的节点的对应的行开始找它的邻接节点并加入队列, 设置为已访问, 直至队列为空
    public void broadFirstSearch() {
        Queue<Integer> queue = new Queue<>();
        boolean[] visited = new boolean[vertexList.size()];
        queue.add(0);
        System.out.println(vertexList.get(queue.remove()));
        visited[0] = true;
        for(int i = 0; i < edges.length; ) {
            for(int j = i + 1; j < edges[i].length; j++) { // 有向图将 j = i + 1 设为 0
                if(edges[i][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
            if(queue.isEmpty()) break;
            i = queue.remove(); // 从该节点对应的行开始访问, 第 i 行
            System.out.println(vertexList.get(i));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(new String[]{"A", "B", "C", "D", "E", "F", "G", "H"});
        graph.modifyEdge(0, 1, 1);
        graph.modifyEdge(0, 2, 1);
        graph.modifyEdge(2, 5, 1);
        graph.modifyEdge(2, 6, 1);
        graph.modifyEdge(5, 6, 1);
        graph.modifyEdge(1, 3, 1);
        graph.modifyEdge(1, 4, 1);
        graph.modifyEdge(3, 7, 1);
        graph.modifyEdge(4, 7, 1);
        graph.depthFirstSearch();
        System.out.println();

    }


}
