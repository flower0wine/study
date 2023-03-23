package Algorithms.ClassicAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 27 13:20
 *
 * 克鲁斯卡尔算法应用 (公交问题)
 */
public class KruskalAlgorithm {
    // 图
    private int[][] graph;
    // 权重
    private int[][] edgeWight;
    // 节点名称
    private char[] nodeName;

    public KruskalAlgorithm(int[][] graph, int[][] edgeWight, char[] nodeName) {
        this.graph = graph;
        this.edgeWight = edgeWight;
        this.nodeName = nodeName;
    }

    // 从所有的边中选出最短的边连接，并且要求连接后不能构成回路, 没有构成回路的条件就是连接前两个节点的终点不一样
    public void kruskalAlgorithm() {
        char[] destination = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'}; // 每一个节点的终点
        int before = 0, after = 0, min = Integer.MAX_VALUE, t; // min = Integer.MAX_VALUE 是因为权重矩阵中有 0
        short validSize = 0; // 有效个数
        while (++validSize < graph.length) {
            for(int i = 0; i < edgeWight.length; i++) {
                for(int j = 0; j < edgeWight[i].length; j++) {
                    if(destination[i] != destination[j] && (t = edgeWight[i][j]) != 0 && min > t) { // 当两个相邻节点终点不同且权重较短时
                        min = t;
                        before = i;
                        after = j;
                    }
                }
            }

            if(destination[before] < destination[after]) { // 设置终点为数值较大的节点
                setDestination(destination[before], destination[after], destination);
            } else {
                setDestination(destination[after], destination[before], destination);
            }
            System.out.println(nodeName[before] + " --> " + nodeName[after] + " : " + min);
            min = Integer.MAX_VALUE; // 重置
        }
    }

    // 更新每一个节点的终点, 将所有以 before 为终点的节点, 她们的终点改为 after
    private void setDestination(char before, char after, char[] destination) {
        for(int i = 0; i < destination.length; i++) {
            if(destination[i] == before) {
                destination[i] = after;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[7][7];
        graph[0][1] = 1;
        graph[0][6] = 1;
        graph[0][5] = 1;
        graph[1][0] = 1;
        graph[1][2] = 1;
        graph[1][6] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[2][4] = 1;
        graph[2][5] = 1;
        graph[3][2] = 1;
        graph[3][4] = 1;
        graph[4][2] = 1;
        graph[4][3] = 1;
        graph[4][6] = 1;
        graph[4][5] = 1;
        graph[6][0] = 1;
        graph[6][4] = 1;
        graph[6][5] = 1;
        graph[5][0] = 1;
        graph[5][1] = 1;
        graph[5][2] = 1;
        graph[5][4] = 1;
        graph[5][6] = 1;
        int[][] edgeWeight = new int[7][7];
        edgeWeight[0][1] = 12;
        edgeWeight[0][6] = 14;
        edgeWeight[0][5] = 16;
        edgeWeight[1][0] = 12;
        edgeWeight[1][2] = 10;
        edgeWeight[1][5] = 7;
        edgeWeight[2][1] = 10;
        edgeWeight[2][3] = 3;
        edgeWeight[2][4] = 5;
        edgeWeight[2][5] = 6;
        edgeWeight[3][2] = 3;
        edgeWeight[3][4] = 4;
        edgeWeight[4][2] = 5;
        edgeWeight[4][3] = 4;
        edgeWeight[4][6] = 8;
        edgeWeight[4][5] = 2;
        edgeWeight[6][0] = 14;
        edgeWeight[6][4] = 8;
        edgeWeight[6][5] = 9;
        edgeWeight[5][0] = 16;
        edgeWeight[5][1] = 7;
        edgeWeight[5][2] = 6;
        edgeWeight[5][4] = 2;
        edgeWeight[5][6] = 9;
        char[] nodeName = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(graph, edgeWeight, nodeName);
        kruskalAlgorithm.kruskalAlgorithm();

    }
}
