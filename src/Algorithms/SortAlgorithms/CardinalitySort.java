package Algorithms.SortAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 09 17:12
 *
 * 基数排序
 */
public class CardinalitySort {

    private int[] arr;

    // 数组初始化
    private void initialArray(){
        arr = new int[]{601, 49, 1, 23, 9, 748};
    }

    private void initialArray(int n){
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * 100000);
        }
    }

    // 基数排序
    private void sort(){
        this.sort(arr.length);
    }

    private void sort(int n){
        int[][] temp = new int[10][n];
        int[] index = new int[10];
        int num = 0;
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        while (max != 0){
            max /= 10;
            num++;
        }
        for(int i = num; i > 0; i--){
            for(int j = 0; j < arr.length; j++){
                int a = arr[j];
                int b = (int)(Math.pow(10, num - i));
                a /= b;
                a %= 10;
                temp[a][index[a]] = arr[j];
                index[a]++;
            }
            for(int a = 0, c = 0; a < index.length; a++){
                for(int b = 0; b < index[a] && c < arr.length; b++){
                    arr[c++] = temp[a][b];
                }
                index[a] = 0;
            }
        }
    }

    private void showArray(){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        CardinalitySort cardinalitySort = new CardinalitySort();
        cardinalitySort.initialArray(80000);
        long l = System.currentTimeMillis();
        cardinalitySort.sort();
        long l1 = System.currentTimeMillis();
        cardinalitySort.showArray();
        System.out.println(l1 - l);
    }
}
