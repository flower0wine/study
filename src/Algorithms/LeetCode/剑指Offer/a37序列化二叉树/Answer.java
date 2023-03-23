package Algorithms.LeetCode.剑指Offer.a37序列化二叉树;

import Algorithms.DataStructure.Queue.Queue;
import Algorithms.LeetCode.TreeNode;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Answer {

    /**
     * 序列化
     */
    public String serialize(TreeNode treeNode) {
        if(treeNode == null) {
            return "null";
        }
        // 所有层数
        int allLayer = getLayer(treeNode);
        // 当前层数
        int curLayer = 1;
        Queue<TreeNode> queue = new Queue<>();
        StringBuilder stringBuilder = new StringBuilder("[");
        queue.add(treeNode);
        while (!queue.isEmpty()) {

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private int getLayer(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        return Math.max(getLayer(treeNode.left), getLayer(treeNode.right)) + 1;
    }

    /**
     * 反序列化
     */
    public TreeNode deserialize(String data) {
        return null;
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        TreeNode treeNode = new TreeNode(
                new TreeNode(2),
                new TreeNode(
                        new TreeNode(4),
                        new TreeNode(5),
                        3
                ),
                1
        );

        System.out.println(answer.getLayer(treeNode));

        // 序列化
        String serialize = answer.serialize(treeNode);
        System.out.println(serialize);

        // 反序列化
        TreeNode deserialize = answer.deserialize(serialize);
        System.out.println(deserialize);
    }
}
