package Algorithms.ClassicAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 28 23:38
 * <p>
 * 弗洛伊德算法应用 (求所有两点搭配的最短路径)
 */
public class FloydAlgorithm {
    private int[][] graph;
    private char[] nodeName;
    private int[][] preNode;

    public FloydAlgorithm(int[][] graph, char[] nodeName) {
        this.nodeName = nodeName;
        this.graph = graph;
        preNode = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                preNode[j][i] = j;
            }
        }
    }

    public void floydAlgorithm(int start, int end) {
        for (int i = 0; i < graph.length; i++) { // 中间顶点
            for (int j = 0; j < graph.length; j++) { // 出发顶点
                for (int k = 0; k < graph.length; k++) { // 终点
                    int t;
                    // 当两个节点通过某个中间节点得到的路径权重相加后小于两个节点直接相连时的路径权重时, 特别注意当两个节点没有直接相连时权重为 "无穷大"
                    if (graph[i][j] != 0 && graph[i][k] != 0 && (t = graph[i][j] + graph[i][k]) < graph[j][k]) {
                        graph[j][k] = graph[k][j] = t; // 记录两个节点目前相距的最短路径
                        preNode[j][k] = preNode[k][j] = i; // 记录中间节点
                    }
                }
            }
        }
        show(start, end);
        System.out.print(nodeName[end]);
        System.out.println("\n路径权重为 " + graph[start][end]);
    }

    private void show(int before, int after) {
        if (preNode[before][after] == before) {
            System.out.print(nodeName[before] + " -> ");
            return;
        }
        show(before, preNode[before][after]);
        show(preNode[before][after], after);
    }

    public static void main(String[] args) {
        int[][] graph = new int[7][7];
        int N = 100;
        graph[0] = new int[]{0, 5, 7, N, N, N, 2};
        graph[1] = new int[]{5, 0, N, 9, N, N, 3};
        graph[2] = new int[]{7, N, 0, N, 8, N, N};
        graph[3] = new int[]{N, 9, N, 0, N, 4, N};
        graph[4] = new int[]{N, N, 8, N, 0, 5, 4};
        graph[5] = new int[]{N, N, N, 4, 5, 0, 6};
        graph[6] = new int[]{2, 3, N, N, 4, 6, 0};
        char[] nodeName = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        FloydAlgorithm floydAlgorithm = new FloydAlgorithm(graph, nodeName);
        floydAlgorithm.floydAlgorithm(2, 3);
    }
}
