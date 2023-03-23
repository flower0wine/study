package Algorithms.ClassicAlgorithms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 29 14:25
 * <p>
 * 骑士周游算法
 */
public class KnightTour {
    private boolean[][] chessBroad;
    private int[][] order;
    private int all = 0;
    private int broadLength;

    static class Position {
        int row;
        int rol;

        public Position(int row, int rol) {
            this.row = row;
            this.rol = rol;
        }
    }

    public KnightTour(int broadLength) {
        this.broadLength = broadLength;
        this.chessBroad = new boolean[broadLength][broadLength];
        this.order = new int[broadLength][broadLength];
    }

    public void start(int startRow, int startRol) {
        knightTourPro(startRow, startRol);
        show();
    }

    // 骑士周游算法: 自妍(未优化)
    private boolean knightTour(int i, int j) {
        if (i >= 0 && i < chessBroad.length && j >= 0 && j < chessBroad.length && !chessBroad[i][j]) {
            order[i][j] = ++all; // 计数
            chessBroad[i][j] = true; // 标记为已经跳过
            if (all == broadLength * broadLength) { // 当次数符合要求退出
                return true;
            }
            boolean t; // 该变量返回跳的这八个方向是否能够胜利, 如果这八个方向都不能胜利, 将返回 false, 否则返回 true
            t = knightTour(i - 2, j - 1) || knightTour(i - 1, j - 2) || knightTour(i + 1, j - 2) ||
                    knightTour(i + 2, j - 1) || knightTour(i + 2, j + 1) || knightTour(i + 1, j + 2) ||
                    knightTour(i - 1, j + 2) || knightTour(i - 2, j + 1);
            if (!t) { // 根据返回的方向是否正确, 来判断回溯时是否要重置跳过的位置的值
                chessBroad[i][j] = false;
                all--; // 计数回溯
            }
            return t;
        }
        return false; // 当越界或者该位置已经跳过
    }

    // 骑士周游算法, 优化版 (非自妍)
    private void knightTourPro(int i, int j) {
        if (i >= 0 && i < chessBroad.length && j >= 0 && j < chessBroad.length && !chessBroad[i][j]) {
            order[i][j] = ++all; // 计数
            chessBroad[i][j] = true; // 标记为已经跳过

            List<Position> list = next(i, j);
            list.sort(Comparator.comparingInt(o -> positionNumber(o.row, o.rol)));
            while (!list.isEmpty()) {
                Position p = list.remove(0);
                knightTourPro(p.row, p.rol);
            }

            if (all < broadLength * broadLength) { // 根据返回的方向是否正确, 来判断回溯时是否要重置跳过的位置的值
                chessBroad[i][j] = false;
                all--; // 计数回溯
            }
        }
    }

    // 返回能走的方向的集合
    private List<Position> next(int row, int col) {
        List<Position> list = new ArrayList<>();
        int b = 2, c = 1, d, e;
        for (int a = -2; a <= 2; a++) {
            if (a == 0) continue;
            do {
                c = -c;
                if ((d = row + a) >= 0 && d < broadLength && (e = col + (b / a * c)) >= 0 && e < broadLength && !chessBroad[d][e]) {
                    list.add(new Position(d, e));
                }
            } while (c != 1);
        }
        return list;
    }

    // 计算该位置有多少可以走的方向的数量
    private int positionNumber(int i, int j) {
        int sum = 0, b = 2, c = 1, d, e;
        for (int a = -2; a <= 2; a++) {
            if (a == 0) continue;
            do {
                c = -c;
                // 这里自己为了减少代码量, 使用如下条件进行判断
                if ((d = i + a) >= 0 && d < broadLength && (e = j + (b / a * c)) >= 0 && e < broadLength && !chessBroad[d][e]) {
                    sum++;
                }
            } while (c != 1);
        }
        return sum;
    }


    private void show() {
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < order[i].length; j++) {
                System.out.printf("%4d", order[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KnightTour knightTour = new KnightTour(8);
        knightTour.start(2, 7);


    }
}
