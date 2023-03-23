package Algorithms.SortAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 07 10:47
 * <p>
 * 插入排序
 */
public class InsertSort {
    private int[] arr;

    // 初始化数组
    private void initialArray() {
        arr = new int[]{2, 4, 1, 6, 0, 5, 3, 7};
    }

    // 随机数组
    private void initialArray(int n) {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
    }

    // 插入排序
    private void sort() {
        int insertVal;
        int index;
        // i 不从 0 开始是因为从 0 开始没有必要, 下面语句不会遍历其它元素, 只有 arr[0] 一个, 更不会有元素更换
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            index = i;
            // 当发现 insertVal 比 arr[index - 1] 小时, arr[index - 1] 元素后移， 这里实现的是从小到大的顺序
            while (index - 1 >= 0 && arr[index - 1] > insertVal) {
                arr[index] = arr[index - 1];
                index--;
            }
            // 当元素发生移动时才会满足下面的情况
            if (index != i) {
                arr[index] = insertVal;
            }
        }
    }

    private void showArray() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        insertSort.initialArray();
        long l = System.currentTimeMillis();
        insertSort.sort();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
