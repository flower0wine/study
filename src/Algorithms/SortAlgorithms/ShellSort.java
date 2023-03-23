package Algorithms.SortAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 07 16:23
 * <p>
 * 希尔排序
 */
public class ShellSort {

    private int[] arr;

    // 初始化数组
    private void initialArray() {
        arr = new int[]{2, 4, 1, 6, 9, 8, 5, 7, 3, 0};
    }

    private void initialArray(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
    }

    // 希尔排序: 交换法
    private void sortChange() {
        int temp;
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i++) {
                for (int j = i - increment; j >= 0; j -= increment) {
                    if (arr[j] > arr[j + increment]) {
                        temp = arr[j];
                        arr[j] = arr[j + increment];
                        arr[j + increment] = temp;
                    }
                }
            }
        }
    }

    // 希尔排序: 移位法
    private void sortMove() {
        int j;
        int temp;
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i++) {
                j = i;
                temp = arr[i];
                if(arr[j - increment] > temp){
                    while (j - increment >= 0 && arr[j - increment] > temp) {
                        arr[j] = arr[j - increment];
                        j -= increment;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    // 希尔排序: 基于选择排序
    private void sortSelect() {
        int min;
        int index;
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment - 1; i < arr.length - 1; i += increment) {
                min = arr[i];
                index = i;
                for(int j = i + increment; j < arr.length; j += increment){
                    if(arr[j] < min) {
                        index = j;
                        min = arr[j];
                    }
                }
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }

    private void showArray() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.initialArray();
        long l = System.currentTimeMillis();
        shellSort.sortMove();
        shellSort.showArray();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
