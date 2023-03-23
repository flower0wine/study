package Algorithms.LeetCode.剑指Offer.a07_重建二叉树;

import Algorithms.LeetCode.TreeNode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Function 将中序遍历和后序遍历的结构重新组成二叉树
 * @Start_Time 2023 01 18 17:40
 */

public class InSufOrder {
    // 默认数据
    private int[] inOrder;
    private int[] sufOrder;
    // 在 sufOrder 中的索引
    private int sufOrderIndex = 0;
    // 错误提示
    private String distinctTip = "中序遍历和后序遍历结果不是同一个树遍历的结果 inOrder[%d] = %d 和 sufOrder[%d] = %d";
    private String distinctTree = "中序遍历和后序遍历不匹配, 前序遍历 inOrder[%d] = %d 无法在 sufOrder 范围为 %d ~ %d 中找到";


    // 默认值
    public TreeNode answer() {
        this.inOrder = new int[]{2, 5, 4, 3, 0, 7, 9};
        this.sufOrder = new int[]{2, 4, 5, 0, 9, 7, 3};
        this.sufOrderIndex = sufOrder.length - 1;
        return answer(inOrder, sufOrder);
    }

    // 自己赋值
    public TreeNode answer(int[] inOrder, int[] sufOrder) {
        if(inOrder != null && sufOrder != null && inOrder.length != 0 && sufOrder.length != 0) {
            if(inOrder.length == sufOrder.length && inOrder.length == 1) {  // 只有一个节点
                if(inOrder[0] == sufOrder[0]) {
                    return new TreeNode(inOrder[0]);
                }
                // 不相同
                throw new RuntimeException(String.format(distinctTip, 0, inOrder[0], 0, sufOrder[0]));
            } else {
                return merge(0, sufOrder.length - 1);
            }
        }
        return null;
    }

    // 创建节点并合并子树
    private TreeNode merge(int left, int right) {
        if(left == right) { // 只有一个节点
            sufOrderIndex--;
            return new TreeNode(inOrder[left]);
        } else {
            TreeNode treeNode = new TreeNode(sufOrder[sufOrderIndex]);
            int index = searchDateInOrder(left, right);
            sufOrderIndex--;
            if(index < right) { // index 右边还有节点
                treeNode.right = merge(index + 1, right);
            }
            if(index > left) {  // index 左边还有节点
                treeNode.left = merge(left, index - 1);
            }
            return treeNode;
        }
    }

    // 搜索 sufOrderIndex 在 sufOrder 中的索引
    private int searchDateInOrder(int left, int right) {
        for(int i = left; i <= right; i++) {
            if(inOrder[i] == sufOrder[sufOrderIndex]) {
                return i;
            }
        }
        // 没有找到抛出异常
        throw new RuntimeException(String.format(distinctTree, sufOrderIndex, sufOrder[sufOrderIndex], left, right));
    }

    public static void main(String[] args) {
        InSufOrder inSufOrder = new InSufOrder();
        TreeNode treeNode = inSufOrder.answer();
        System.out.println(treeNode);
    }
}
