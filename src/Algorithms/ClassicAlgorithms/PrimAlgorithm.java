package Algorithms.ClassicAlgorithms;

import java.util.*;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 26 13:11
 * <p>
 * 普里姆算法应用 (修路问题)
 */
public class PrimAlgorithm {
    // 图
    private int[][] graph;
    // 权值
    private int[][] edgeWeight;
    // 名称
    private String[] nameOfIndex;

    public PrimAlgorithm(int[][] graph, int[][] edgeWeight, String[] nameOfIndex) {
        this.graph = graph;
        this.edgeWeight = edgeWeight;
        this.nameOfIndex = nameOfIndex;
    }

    // 普里姆算法
    public void primAlgorithm() {
        boolean[] visited = new boolean[graph.length];
        int i = 0;// 从第一个节点开始
        visited[i] = true;
        primAlgorithm(visited);
    }

    // 原理: 从访问过的节点开始, 找出其所有的邻近节点, 并比较访问过的节点与其邻近未访问过的节点的所有路径长度, 选出最短的路径
    private void primAlgorithm(boolean[] visited) {
        int validSize = 0, minWeight = 1000, before = 0, after = 0;
        while (++validSize != visited.length) { // 当节点全部访问后退出
            for (int i = 0; i < graph.length; i++) { // 找寻所有节点
                if(!visited[i]) { // 当前节点未访问, continue
                    continue;
                }
                for (int j = 0; j < graph[i].length; j++) { // 当前节点已访问, 找出该节点与其所有邻近未访问的节点之间的路径
                    if (graph[i][j] != 0 && !visited[j] && edgeWeight[i][j] < minWeight) {  // 如果当前邻近节点未被访问, 且该节点与该邻近节点之间
                        minWeight = edgeWeight[i][j];                                       // 的路径权重要小于 minWeight
                        before = i; // 记录当前节点的下标
                        after = j;  // 记录当前节点的邻近节点的下标
                    }
                }
            }
            visited[after] = true; // 邻近节点标记为已访问
            minWeight = 1000;
            System.out.println(nameOfIndex[before] + " --> " + nameOfIndex[after] + " : " + edgeWeight[before][after]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[7][7];
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[0][6] = 1;
        graph[1][0] = 1;
        graph[1][3] = 1;
        graph[1][6] = 1;
        graph[2][0] = 1;
        graph[2][4] = 1;
        graph[3][1] = 1;
        graph[3][5] = 1;
        graph[4][2] = 1;
        graph[4][5] = 1;
        graph[4][6] = 1;
        graph[5][4] = 1;
        graph[5][3] = 1;
        graph[5][6] = 1;
        graph[6][0] = 1;
        graph[6][1] = 1;
        graph[6][4] = 1;
        graph[6][5] = 1;
        int[][] edgeWeight = new int[7][7];
        edgeWeight[0][1] = 5;
        edgeWeight[0][2] = 7;
        edgeWeight[0][6] = 2;
        edgeWeight[1][0] = 5;
        edgeWeight[1][3] = 9;
        edgeWeight[1][6] = 3;
        edgeWeight[2][0] = 7;
        edgeWeight[2][4] = 8;
        edgeWeight[3][1] = 9;
        edgeWeight[3][5] = 4;
        edgeWeight[4][2] = 8;
        edgeWeight[4][5] = 5;
        edgeWeight[4][6] = 4;
        edgeWeight[5][4] = 5;
        edgeWeight[5][3] = 4;
        edgeWeight[5][6] = 6;
        edgeWeight[6][0] = 2;
        edgeWeight[6][1] = 3;
        edgeWeight[6][4] = 4;
        edgeWeight[6][5] = 6;
        String[] nameOfIndex = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        PrimAlgorithm primAlgorithm = new PrimAlgorithm(graph, edgeWeight, nameOfIndex);
        primAlgorithm.primAlgorithm();
    }
}
