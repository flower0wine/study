package Algorithms.DataStructure.Tree;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 18 16:13
 * <p>
 * 赫夫曼树
 */
public class HuffmanTree {
    private TreeNode root;
    private TreeNode[] arr;

    public HuffmanTree() {
        arr = new TreeNode[8];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new TreeNode(i + 1, null, null);
        }
    }

    public HuffmanTree(int n) {
        arr = new TreeNode[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new TreeNode((int)(Math.random() * 20), null, null);
        }
    }

    private static final class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return " data=" + data;

        }
    }

    public TreeNode createHuffmanTree() {
        for (int i = 0; i < arr.length - 1; i++) {
            headSort(arr);
            arr[i + 1] = new TreeNode(arr[i].data + arr[i + 1].data, arr[i], arr[i + 1]);
        }
        return arr[arr.length - 1];
    }

    private void headSort(TreeNode[] arr) {
        TreeNode temp;
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            headSort(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            headSort(arr, 0, i);
        }
    }

    private void headSort(TreeNode[] arr, int top, int length) {
        TreeNode temp = arr[top];
        for (int i = top * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && arr[i].data < arr[i + 1].data) {
                i++;
            }
            if (arr[i].data > temp.data) {
                arr[top] = arr[i];
                top = i;
            } else {
                break;
            }
        }
        arr[top] = temp;
    }

    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();

        TreeNode root = huffmanTree.createHuffmanTree();
        System.out.println();
    }

}
