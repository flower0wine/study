package Algorithms.SortAlgorithms;

import java.util.Arrays;
import java.util.Date;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 07 9:45
 *
 * 选择排序
 */
public class SelectSort {

    private int[] arr;

    // 初始化数组
    private void initialArray(){
        arr = new int[]{6, 5, 7, 1, 8, 2, 3, 4};
    }

    // 随机数组
    private void initialArray(int n){
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * 100000);
        }
    }

    private void sort(){
        int c;
        int temp;
        for(int i = 0; i < arr.length - 1; i++){    // 减一的原因是 i 等于 arr.length - 1 时，只剩下最后一个元素没有排序，但最后一个元素顺序是一定正确的，故不需要排序
            c = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[c]){
                    // 记录最小值的下标
                    c = j;
                }
            }
            // 第 n 次找到的较小值与 arr[n - 1] 交换
            if(c != i){
                temp = arr[c];
                arr[c] = arr[i];
                arr[i] = temp;
            }
        }
    }

    private void showArray(){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        selectSort.initialArray(80000);
        long l = System.currentTimeMillis();
        selectSort.sort();
        selectSort.showArray();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
