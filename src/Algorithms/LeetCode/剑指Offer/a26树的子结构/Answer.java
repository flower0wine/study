package Algorithms.LeetCode.剑指Offer.a26树的子结构;

import Algorithms.LeetCode.TreeNode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 29 17:58
 */
public class Answer extends TreeNode {
    // 验证是否匹配
    private boolean justifyMatch(TreeNode treeNode, TreeNode matchedTree) {
        if (treeNode != null && matchedTree != null) {
            if (treeNode.data == matchedTree.data) {
                return justifyMatch(treeNode.left, matchedTree.left) && justifyMatch(treeNode.right, matchedTree.right);
            } else {
                return false;
            }
        }
        return matchedTree == null; // 匹配节点为 null
    }

    // 查找相同的根节点再进行比较
    private boolean answer(TreeNode originalTree, TreeNode matchedTree) {
        if (originalTree != null && matchedTree != null) {
            if (originalTree.data == matchedTree.data) {    // 根节点相同进行比较
                return justifyMatch(originalTree, matchedTree);
            }
            return answer(originalTree.left, matchedTree) || answer(originalTree.right, matchedTree);   // 不同再进行左节点、右节点查找
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(new TreeNode(new TreeNode(null, null, 1), new TreeNode(null, null, 2), 4), new TreeNode(null, null, 5), 3);
        TreeNode treeNode2 = new TreeNode(new TreeNode(null, null, 1), null, 4);
        Answer answer = new Answer();
        boolean b = answer.answer(treeNode1, treeNode2);
        System.out.println(b);
    }
}
