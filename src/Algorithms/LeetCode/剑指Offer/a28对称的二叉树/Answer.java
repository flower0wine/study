package Algorithms.LeetCode.剑指Offer.a28对称的二叉树;

import Algorithms.LeetCode.TreeNode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 30 15:36
 */
public class Answer extends TreeNode {
    private boolean answer(TreeNode treeNode) {
        if(treeNode != null) {
            return justifyMirrorTree(treeNode.left, treeNode.right);    // 根据根节点拆成左子树和右子树
        }
        return false;   // 为 null 则非镜像树
    }

    // 判断是否是镜像树
    private boolean justifyMirrorTree(TreeNode treeLeft, TreeNode treeRight) {
        if(treeRight != null && treeLeft != null) { // 镜像树要求同不为 null 或同为 null
            if(treeRight.data == treeLeft.data) {   // 数据相同继续查找
                return justifyMirrorTree(treeLeft.left, treeRight.right) && justifyMirrorTree(treeLeft.right, treeRight.left);
            }
            return false;   // 数据不同时
        }
        return treeRight == null && treeLeft == null;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(new TreeNode(null, null, 3), new TreeNode(null, null, 4), 2), new TreeNode(new TreeNode(null, null, 4), new TreeNode(null, null, 3), 2), 1);
        Answer answer = new Answer();
        boolean b = answer.answer(treeNode);
        System.out.println(b);
    }
}
