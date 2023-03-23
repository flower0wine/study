package Algorithms.ClassicAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 05 10:35
 *
 * 迷宫回溯问题
 */
public class LabyrinthBacktracking {

    private int[][] map;

    // 创建地图
    public void createMap(int rows, int cols) {
        this.map = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            map[i][0] = 1;
            map[i][cols - 1] = 1;
        }
        for (int i = 0; i < cols; i++) {
            map[0][i] = 1;
            map[rows - 1][i] = 1;
        }
        this.setObstacle();
        this.seekWay(map, 1, 1);
    }

    // 设置障碍
    private void setObstacle() {
        map[3][1] = 1;
        map[3][2] = 1;
        map[6][2] = 1;
        map[7][3] = 1;
        map[6][4] = 1;
        map[5][5] = 1;
        map[4][6] = 1;
        map[3][7] = 1;
        map[2][8] = 1;
        map[3][9] = 1;
        map[4][10] = 1;
        map[5][11] = 1;
        map[6][12] = 1;
        map[8][13] = 1;
        map[7][14] = 1;
    }

    // 走迷宫, 原理就是走错了回到上一步, 就像悔棋一样
    private boolean seekWay(int[][] map, int i, int j) {
        if (map[map.length - 2][map[map.length - 1].length - 2] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (seekWay(map, i + 1, j)) {
                    return true;
                } else if (seekWay(map, i, j + 1)) {
                    return true;
                } else if (seekWay(map, i - 1, j)) {
                    return true;
                } else if (seekWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                }
            }
            // 此处返回的 false 包括的情况有 map[i][j] = 1、2、3, 三种情况
            return false;
        }
    }

    // 展示地图
    public void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        LabyrinthBacktracking labyrinthBacktracking = new LabyrinthBacktracking();
        labyrinthBacktracking.createMap(17, 17);
        labyrinthBacktracking.showMap();
    }
}
