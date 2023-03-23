package Algorithms.SearchAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 09 22:21
 *
 * 线性查找
 */
public class LinearSearch {
    private int[] arr;

    // 初始化数组
    private void initialArray(){
        arr = new int[]{1, 3, 4, 2, 5, 6};
    }

    private void initialArray(int n){
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * 100000);
        }
    }

    // 线性查找
    private int search(int target) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        linearSearch.initialArray();
        long l = System.currentTimeMillis();
        System.out.println(linearSearch.search(1));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
