package Algorithms.ClassicAlgorithms;

import Algorithms.DataStructure.Queue.Queue;
import Algorithms.DataStructure.Stack.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 27 16:05
 * <p>
 * 迪杰斯特拉算法应用 (求任意两点的最短路径)
 */
public class DijestraAlgorithm {
    // 图
    private int[][] graph;
    private char[] nodeName;

    // 顶点类
    private static class Vertex {
        int minWeight;
        int id;
        Vertex father;

        public Vertex(int minWeight, int id, Vertex father) {
            this.minWeight = minWeight;
            this.id = id;
            this.father = father;
        }
    }

    public DijestraAlgorithm(int[][] graph, char[] nodeName) {
        this.graph = graph;
        this.nodeName = nodeName;
    }

    // 迪杰斯特拉算法, start 为起点, end 为终点, 寻找两点之间的最短路径
    public void dijestraAlgorithm(int start, int end) {
        List<Vertex> marked = new ArrayList<>(); // 标记过的点
        marked.add(new Vertex(0, start, null));

        List<Vertex> unMarked = new ArrayList<>(); // 未标记过的点
        for (int i = 0; i < graph.length; i++) {
            if (start == i) continue;
            unMarked.add(new Vertex(Integer.MAX_VALUE, i, null)); // 单个点路径权重为 Integer.MAX_VALUE
        }

        while (!unMarked.isEmpty()) {
            Vertex vertex = findMinVertex(marked, unMarked);
            unMarked.remove(vertex); // 将返回的节点从未标记的集合移到标记的集合中
            marked.add(vertex);
        }

        showPath(marked, start, end); // 展示路径
    }

    // 原理: 将所有已经标记过的节点邻近的所有节点的路径权重与当前已标记过的节点的父节点之间的路径相加后计算出来并保存, 然后返回相加后最小路径权重的未访问的邻近节点
    private Vertex findMinVertex(List<Vertex> marked, List<Vertex> unMarked) {
        Vertex vertex = null;
        int M = Integer.MAX_VALUE;
        for (Vertex ve : unMarked) {
            for (Vertex vr : marked) {
                int t = vr.minWeight + graph[vr.id][ve.id]; // 与父节点路径权重叠加
                if (t >= 0 && t <= ve.minWeight) { // 防止 t 越界变为负数
                    ve.minWeight = t;
                    ve.father = vr;
                }
            }
            if (ve.minWeight < M) {
                M = ve.minWeight;
                vertex = ve;
            }
        }
        return vertex;
    }

    private void showPath(List<Vertex> marked, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        for (Vertex v : marked) {
            if (v.id == end) {
                System.out.println("路径长度为" + v.minWeight);
                while (v != null) {
                    stack.push(v.id);
                    v = v.father;
                }
                break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder("从 " + nodeName[start] + " 到 " + nodeName[end] + " 的路径为 ");
        Integer i;
        while ((i = stack.pop()) != null) {
            stringBuilder.append(nodeName[i]);
            if (!stack.isNull()) {
                stringBuilder.append(" -> ");
            }
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {

        int[][] graph = new int[7][7];
        int N = Integer.MAX_VALUE;
        graph[0] = new int[]{0, 5, 7, N, N, N, 2};
        graph[1] = new int[]{5, 0, N, 9, N, N, 3};
        graph[2] = new int[]{7, N, 0, N, 8, N, N};
        graph[3] = new int[]{N, 9, N, 0, N, 4, N};
        graph[4] = new int[]{N, N, 8, N, 0, 5, 4};
        graph[5] = new int[]{N, N, N, 4, 5, 0, 6};
        graph[6] = new int[]{2, 3, N, N, 4, 6, 0};
        char[] nodeName = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        DijestraAlgorithm dijestraAlgorithm = new DijestraAlgorithm(graph, nodeName);
        dijestraAlgorithm.dijestraAlgorithm(0, 3);
    }
}
