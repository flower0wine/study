package Algorithms.LeetCode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 30 15:36
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public Integer data;

    public TreeNode() {
    }

    public TreeNode(Integer data) {
        this.data = data;
    }

    public TreeNode(TreeNode left, TreeNode right, Integer data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
