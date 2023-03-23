package Algorithms.ClassicAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 05 12:49
 * <p>
 * 八个皇后
 */
public class EightEmpresses {

    // 一维数组表示一个棋盘, 下标是第 n + 1 个皇后, 即对应行, 一维数组的内容对应在二维数组中的列
    private int[] chessBoard;
    private int length;
    private int res = 0;

    // 创建棋盘
    public int createChessBoard(int length) {
        this.chessBoard = new int[length];
        this.length = length;
        this.putQueenPosition(0);
        return this.res;
    }

    // 判断皇后位置是否正确
    private boolean judgeQueenPosition(int n) {
        for (int i = 0; i < n; i++) {
            // this.chessBoard[n - 1] == this.chessBoard[i]
            // 1. 如果新加入的皇后与之前的皇后不在一列上, 摆放的皇后由于算法肯定不在一行上
            // Math.abs(n - i) == Math.abs(this.chessBoard[n - 1] - this.chessBoard[i]
            // 2. 如果新加入的皇后与之前的皇后不在同一斜线上
            if (this.chessBoard[n] == this.chessBoard[i] || Math.abs(n - i) == Math.abs(this.chessBoard[n] - this.chessBoard[i])) {
                return false;
            }
        }
        return true;
    }

    // 放置皇后, n 是第 n + 1 个皇后
    private void putQueenPosition(int n) {
        if (n == length) {
            this.res++;
            System.out.println(Arrays.toString(this.chessBoard));
            return;
        }
        for (int i = 0; i < this.length; i++) {
            this.chessBoard[n] = i;
            // 此算法总共 15720 次判断, 此判断有 2056 次是正确的
            if (this.judgeQueenPosition(n)) {
                // 不管该放置方式是否正确, 都会回溯, 只是错误的方式回溯会更快、更早
                this.putQueenPosition(n + 1);
            }
        }
    }

    public static void main(String[] args) {
        EightEmpresses eightEmpresses = new EightEmpresses();
        System.out.println(eightEmpresses.createChessBoard(8));
    }

}
