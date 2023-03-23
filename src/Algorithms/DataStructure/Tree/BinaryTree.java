package Algorithms.DataStructure.Tree;

import java.util.TreeMap;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 12 18:20
 * <p>
 * 二叉排序树（BST）、该类有方法可以使其转为平衡二叉树（AVL）
 */
public final class BinaryTree<T> {
    private int size = 0;

    // 根节点
    private TreeNode<T> root;

    private static final class TreeNode<T> {
        TreeNode<T> left;
        TreeNode<T> right;
        T data;

        public TreeNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    // 创建空树
    public BinaryTree() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public BinaryTree<T> put(T[] arr) {
        for (T t : arr) {
            put(t);
        }
        return this;
    }

    public BinaryTree<T> AVLPut(T[] arr) {
        for (T t : arr) {
            AVLPut(t);
        }
        return this;
    }

    public T AVLPut(T data) {
        if (root == null) {
            root = new TreeNode<>(data);
        } else {
            return AVLPut(data, root);
        }
        return null;
    }

    // 平衡二叉树添加
    private T AVLPut(T data, TreeNode<T> treeNode) {
        if (treeNode == null) return null;
        Comparable<T> comparable = (Comparable<T>) data;
        int cmp = comparable.compareTo(treeNode.data);
        if (cmp > 0) {
            if (treeNode.right != null) {
                AVLPut(data, treeNode.right);
            } else {
                treeNode.right = new TreeNode<>(data);
            }
        } else if (cmp < 0) {
            if (treeNode.left != null) {
                AVLPut(data, treeNode.left);
            } else {
                treeNode.left = new TreeNode<>(data);
            }
        } else {
            return data;
        }

        // 递归添加时, 从添加节点的位置开始执行, 判断当前节点左右子树是否平衡, 并逐渐回溯
        // 如果该节点的左子树高度大于右子树高度 + 1
        if (leftHeight(treeNode) > rightHeight(treeNode) + 1) {
            // 如果该节点左节点的右子树高度大于左子树高度, 主要判断属于 LL 型还是 LR 型, 即是否需要左旋转
            if (rightHeight(treeNode.left) > leftHeight(treeNode.left)) {
                leftRotate(treeNode.left);
            }
            rightRotate(treeNode);
            // 如果该节点的右子树高度大于左子树高度 + 1
        } else if (leftHeight(treeNode) + 1 < rightHeight(treeNode)) {
            if (leftHeight(treeNode.right) > rightHeight(treeNode.right)) {
                rightRotate(treeNode.right);
            }
            leftRotate(treeNode);
        }
        return null;
    }

    // 添加树节点, 相同的值不会覆盖, 数据为 null 的节点也可以加入
    public T put(T data) {
        TreeNode<T> t = root;
        int cmp = 0;
        TreeNode<T> parent = null;
        if (t == null) {
            root = new TreeNode<>(data);
            size++;
            return null;
        } else {
            Comparable<? super T> comparable = (Comparable<? super T>) data;
            while (t != null) {
                parent = t;
                cmp = comparable.compareTo(t.data);
                if (cmp > 0) {
                    t = t.right;
                } else if (cmp < 0) {
                    t = t.left;
                } else {
                    T oldData = t.data;
                    t.data = data;
                    return oldData;
                }
            }
        }
        if (cmp > 0) {
            parent.right = new TreeNode<>(data);
        } else {
            parent.left = new TreeNode<>(data);
        }
        size++;
        return null;
    }

    // 删除树节点
    public TreeNode<T> remove(T data) {
        if (isEmpty() || data == null) {
            return null;
        }
        if (root != null) {
            Comparable<? super T> comparable = (Comparable<? super T>) data;
            int cmp;
            TreeNode<T> t = root;
            TreeNode<T> parent = root;
            while (t != null) {
                cmp = comparable.compareTo(t.data);
                if (cmp > 0) {
                    parent = t; // 保存父节点
                    t = t.right;
                } else if (cmp < 0) {
                    parent = t;
                    t = t.left;
                } else {
                    if (parent == t) {   // 删除节点为头节点
                        if (size == 1) {
                            root = null;
                        } else if (parent.right != null && parent.left == null) {
                            root = root.right;
                        } else if (parent.right == null && parent.left != null) {
                            root = root.left;
                        } else {
                            TreeNode<T> treeNode = root.right;
                            while (treeNode.left != null) {
                                treeNode = treeNode.left;
                            }
                            treeNode.left = root.left;
                            root = root.right;
                        }
                    } else if (parent.left == t) { // 删除节点在其父节点的左侧
                        if (t.right != null) {   // 如果待删除节点有右子树
                            parent.left = t.right;
                            if (t.left != null) {
                                TreeNode<T> r = t.right;
                                while (r.left != null) {  // 处理右子树的左子树
                                    r = r.left;
                                }
                                r.left = t.left;
                            }
                        } else {
                            parent.left = t.left;
                        }
                    } else if (parent.right == t) {  // 删除节点在其父节点的右侧
                        if (t.right != null) {// 如果待删除节点有右子树
                            parent.right = t.right;
                            if (t.left != null) {
                                TreeNode<T> r = t.right;
                                while (r.left != null) {// 处理右子树的左子树
                                    r = r.left;
                                }
                                r.left = t.left;
                            }
                        } else {
                            parent.right = t.left;
                        }
                    }
                    size--;
                    return t;
                }
            }
        }
        return null;
    }

    // 查找值
    public TreeNode<T> getNode(T data) {
        if (isEmpty() || data == null) {
            return null;
        }
        if (root != null) {
            Comparable<? super T> comparable = (Comparable<? super T>) data;
            int cmp;
            TreeNode<T> t = root;
            while (t != null) {
                cmp = comparable.compareTo(t.data);
                if (cmp > 0) {
                    t = t.right;
                } else if (cmp < 0) {
                    t = t.left;
                } else {
                    return t;
                }
            }
        }
        return null;
    }

    // 二叉树转化为数组
    public T[] TreeToArray() {
        if (root == null) return null;
        T[] arr = (T[]) new Object[size];
        k = 0;
        prefixRecursion(root, arr);
        return arr;
    }

    // 返回以当前节点为根节点的树的高度
    private int height(TreeNode<T> treeNode) {
        return Math.max(treeNode.left == null ? 0 : height(treeNode.left), treeNode.right == null ? 0 : height(treeNode.right)) + 1;
    }

    // 返回当前节点的左子树高度
    private int leftHeight(TreeNode<T> treeNode) {
        return treeNode == null ? 0 : treeNode.left == null ? 0 : height(treeNode.left);
    }

    // 返回当前节点右子树高度
    private int rightHeight(TreeNode<T> treeNode) {
        return treeNode == null ? 0 : treeNode.right == null ? 0 : height(treeNode.right);
    }

    // 左旋转
    private void leftRotate(TreeNode<T> treeNode) {
        TreeNode<T> t = new TreeNode<>(treeNode.data);
        t.left = treeNode.left;
        t.right = treeNode.right.left;
        treeNode.left = t;
        treeNode.data = treeNode.right.data;
        treeNode.right = treeNode.right.right;
    }

    // 右旋转
    private void rightRotate(TreeNode<T> treeNode) {
        TreeNode<T> t = new TreeNode<>(treeNode.data);
        t.right = treeNode.right;
        t.left = treeNode.left.right;
        treeNode.right = t;
        treeNode.data = treeNode.left.data;
        treeNode.left = treeNode.left.left;
    }

    private int k = 0;

    // 中序遍历并将数据填入数组
    private void prefixRecursion(TreeNode<T> t, T[] arr) {
        if (t.left != null) {
            prefixRecursion(t.left, arr);
        }
        arr[k++] = t.data;
        if (t.right != null) {
            prefixRecursion(t.right, arr);
        }
    }

    // 遍历二叉树
    public void list() {
        if (root != null) {
            System.out.println("前序遍历");
            prefixList(root);
            System.out.println("\n中序遍历：");
            infixList(root);
            System.out.println("\n后序遍历：");
            suffixList(root);
        }
    }

    // 前序遍历
    private void prefixList(TreeNode<T> t) {
        System.out.print(t.data + " ");
        if (t.left != null) {
            prefixList(t.left);
        }
        if (t.right != null) {
            prefixList(t.right);
        }
    }

    // 中序遍历
    private void infixList(TreeNode<T> t) {
        if (t.left != null) {
            infixList(t.left);
        }
        System.out.print(t.data + " ");
        if (t.right != null) {
            infixList(t.right);
        }
    }

    // 后序遍历
    private void suffixList(TreeNode<T> t) {
        if (t.left != null) {
            suffixList(t.left);
        }
        if (t.right != null) {
            suffixList(t.right);
        }
        System.out.print(t.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
//        tree.put("朱佳军");
//        tree.put("张迎雪");
//        tree.put("孙庆洋");
//        tree.put("王志凯");
//        tree.put("李伟建");
//        tree.put("陈志文");
//        tree.put("江子永");
//        tree.put("黄宇航");
        tree.AVLPut(new Integer[]{1, 2, 3});
        System.out.println(tree.leftHeight(tree.root));
        tree.list();

        System.out.println();
    }
}
