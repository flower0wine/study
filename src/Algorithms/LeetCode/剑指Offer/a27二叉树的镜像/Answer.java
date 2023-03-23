package Algorithms.LeetCode.剑指Offer.a27二叉树的镜像;

import Algorithms.LeetCode.TreeNode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 30 14:18
 */
public class Answer extends TreeNode {
    private TreeNode answer(TreeNode treeNode) {
        TreeNode mirrorTree = new TreeNode(null, null, treeNode.data);
        mirrorTree(treeNode, mirrorTree);
        return mirrorTree;
    }

    private void mirrorTree(TreeNode treeNode, TreeNode mirrorTree) {
        if (treeNode.left != null) {
            mirrorTree.right = new TreeNode(null, null, treeNode.left.data);
            mirrorTree(treeNode.left, mirrorTree.right);
        }
        if (treeNode.right != null) {
            mirrorTree.left = new TreeNode(null, null, treeNode.right.data);
            mirrorTree(treeNode.right, mirrorTree.left);
        }
    }

    // 中序遍历
    private void show(TreeNode treeNode) {
        if (treeNode.left != null) {
            show(treeNode.left);
        }
        System.out.println(treeNode.data);
        if (treeNode.right != null) {
            show(treeNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(new TreeNode(new TreeNode(null, null, 1), new TreeNode(null, null, 3), 2), new TreeNode(new TreeNode(null, null, 6), new TreeNode(null, null, 9), 7), 4);
        Answer answer = new Answer();
        answer.show(treeNode1);
        TreeNode treeNode = answer.answer(treeNode1);
        System.out.println("镜像树");
        answer.show(treeNode);
    }
}
