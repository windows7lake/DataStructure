package solution.datastructure.offer;

import solution.datastructure.common.BinaryTreeNode;

public class ConstructBinaryTree_07 {

    private static BinaryTreeNode constructTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0 ||
                preOrder.length != inOrder.length) return null;

        BinaryTreeNode root = new BinaryTreeNode(preOrder[0]);
        root.setLeft(null);
        root.setRight(null);

        int leftTreeNum = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (root.getValue() == inOrder[i])
                break;
            else
                leftTreeNum++;
        }
        int rightTreeNum = inOrder.length - leftTreeNum - 1;

        if (leftTreeNum > 0) {
            int[] leftPreOrder = new int[leftTreeNum];
            int[] leftInOrder = new int[leftTreeNum];
            for (int i = 0; i < leftTreeNum; i++) {
                leftPreOrder[i] = preOrder[i + 1];
                leftInOrder[i] = inOrder[i];
            }
            BinaryTreeNode leftRoot = constructTree(leftPreOrder, leftInOrder);
            root.setLeft(leftRoot);
        }

        if (rightTreeNum > 0) {
            int[] rightPreOrder = new int[rightTreeNum];
            int[] rightInOrder = new int[rightTreeNum];
            for (int i = 0; i < rightTreeNum; i++) {
                rightPreOrder[i] = preOrder[i + 1 + leftTreeNum];
                rightInOrder[i] = inOrder[i + 1 + leftTreeNum];
            }
            BinaryTreeNode rightRoot = constructTree(rightPreOrder, rightInOrder);
            root.setRight(rightRoot);
        }

        return root;
    }

    //后序遍历
    private static void postOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) return;
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.println(treeNode);
    }

    public static void main(String[] args) {
        // 二叉树的先序序列
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        // 二叉树的中序序列
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = constructTree(preOrder, inOrder);
        postOrder(root);
    }


}
