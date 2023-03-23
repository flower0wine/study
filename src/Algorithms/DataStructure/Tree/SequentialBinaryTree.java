package Algorithms.DataStructure.Tree;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 16 21:17
 *
 * 顺序二叉树: 底层是数组
 */
public class SequentialBinaryTree {
    private int[] arr;

    // 创建空树
    public SequentialBinaryTree(int n) {
        if(n < 0) return;
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
    }

    // 中序遍历
    public void infixList() {
        infixList(0);
    }

    private void infixList(int index) {
        if(arr != null) {
            int i;
            if((i = index * 2 + 1) < arr.length) {
                infixList(i);
            }
            System.out.println(arr[index]);
            if((i = index * 2 + 2) < arr.length) {
                infixList(i);
            }
        }
    }

    public static void main(String[] args) {
        SequentialBinaryTree sequentialBinaryTree = new SequentialBinaryTree(7);
        sequentialBinaryTree.infixList();
    }


}
