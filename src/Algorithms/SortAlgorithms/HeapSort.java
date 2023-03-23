package Algorithms.SortAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 16 20:45
 * <p>
 * 堆排序: 排序时为从下往上，从右往左的规律
 */
public class HeapSort {

    private int[] arr;

    public HeapSort() {
        arr = new int[]{3, 6, 1, 0, 5, 2, 4};
    }

    public HeapSort(int n) {
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 100000);
        }
    }

    // 该排序主要是确保所有的父节点比它的两个子节点都要大, 如果小的话就交换父子节点的值，最终最大的值就会运至堆顶
    private void headSort(int top, int length) {
        int temp = arr[top];
        for (int i = top * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[top] = arr[i];
                top = i; // 赋值给 top 后则从子节点继续向下比较
            } else {
                break; // 由于是从最后一个非叶子节点开始遍历的，所以父节点大于子节点的话，那也一定大于子节点的子节点
            }
        }
        arr[top] = temp;
    }

    // 堆排序
    public void headSort() {
        int temp;
        // 该循环从下往上，从右往左结束后, 就一定保证所有的父节点均大于等于其子节点，故该循环结束后顺序大体就整齐了
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            headSort(i, arr.length);
        }

        System.out.println(Arrays.toString(arr));

        for(int j = arr.length - 1; j > 0; j--) {   // 由于所有的父节点均大于其子节点，所以堆顶就是最大值，并放置在数组尾部
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            headSort(0, j); // 如果当前的堆顶元素小于其子节点，则最大值不是子节点就是右节点, 反之堆顶元素直接放在数组后面
                                // 如果之前的堆顶元素比子节点的子节点还要小, 就将该子节点赋值给它的父节点, 这里是为了让所有的父节点大于其子节点，
                                // 即更大的数作为父节点, 不是为了纯粹找堆顶元素的位置
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        long l = System.currentTimeMillis();
        heapSort.headSort();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
