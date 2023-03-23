package Algorithms.LeetCode.剑指Offer.a36二叉搜索树和双向链表;

import Algorithms.LeetCode.TreeNode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Function
 * @Start_Time 2023 01 26 18:15
 */
public class Answer {

    public TreeNode answer(TreeNode treeNode) {
        TreeNode head = infix(treeNode);
        TreeNode t = infixOrder(treeNode);
        head.left = t;
        t.right = head;
        return head;
    }

    public TreeNode infix(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return treeNode;
        }
        if (treeNode.left != null) {
            return infix(treeNode.left);
        }
        return infix(treeNode.right);
    }

    /**
     * 中序遍历
     */
    public TreeNode infixOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        // 叶子节点
        if (treeNode.left == null && treeNode.right == null) {
            return treeNode;
        }
        TreeNode t = null;
        // 从左子树递归
        if (treeNode.left != null) {
            t = infixOrder(treeNode.left);
        }
        if (t != null) {
            t.right = treeNode;
            treeNode.left = t;
        }
        // 右子树递归
        if (treeNode.right != null) {
            t = infixOrder(treeNode.right);
        }
        if (t != null) {
            treeNode.right = t;
            t.left = treeNode;
        }
        return t;
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        TreeNode treeNode = answer.answer(
                new TreeNode(
                        new TreeNode(
                                new TreeNode(1),
                                new TreeNode(3),
                                2),
                        new TreeNode(5),
                        4)
        );
        System.out.println(treeNode);
    }
}
