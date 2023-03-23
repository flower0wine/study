package Algorithms.SortAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 07 22:51
 *
 * 快速排序
 */
public class QuickSort {

    private int[] arr;

    // 初始化数组
    private void initialArray(){
        arr = new int[]{100, 99, 98, 97, 96, 95, 80, 81, 82, 83, 84, 70, 71, 72, 73, 100};
    }

    private void initialArray(int n){
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * 100000);
        }
    }

    // 快速排序
    private void sort(int arr[], int left, int right){
        if(left >= right) return;
        int l = left;
        int r = right;
        int pivot = arr[left];
        while (l < r){
            while (r > l && arr[r] >= pivot){ // 必须加等于号, 与基准值相等的数无论在基准值左边或右边均可
                r--;
            }
            arr[l] = arr[r];    // r 左移一遍后找到比基准值小的赋给 l
            while (l < r && arr[l] <= pivot){
                l++;
            }
            arr[r] = arr[l];    // l 右移一遍后找到比基准值大的赋给 r
            if(r == l){
                arr[r] = pivot; // 相等就说明基准值左边都比基准值小，右边都比基准值大，该位置应为基准值
            }
        }
        sort(arr, left, l - 1); // 左递归
        sort(arr, r + 1, right); // 右递归
    }

    private void showArray(){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.initialArray(80000);
        long l = System.currentTimeMillis();
        quickSort.sort(quickSort.arr, 0, quickSort.arr.length - 1);
        long l1 = System.currentTimeMillis();
        quickSort.showArray();
        System.out.println(l1 - l);
    }
}
