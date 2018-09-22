package solution.datastructure.offer;

import solution.datastructure.common.BinaryTreeNode;

public class MirrorOfBinaryTree_27 {

    public static void getMirrorTree(BinaryTreeNode pHead) {
        if (pHead == null) return;
        if (pHead.getLeft() == null && pHead.getRight() == null) return;

        BinaryTreeNode temp = pHead.getLeft();
        pHead.setLeft(pHead.getRight());
        pHead.setRight(temp);

        if (pHead.getLeft() != null) getMirrorTree(pHead.getLeft());
        if (pHead.getRight() != null) getMirrorTree(pHead.getRight());
    }

    public static void visit(BinaryTreeNode subTree) {
        System.out.println(subTree.getStr());
    }

    //前序遍历
    public static void preOrder(BinaryTreeNode subTree) {
        if (subTree == null) return;
        visit(subTree);
        preOrder(subTree.getLeft());
        preOrder(subTree.getRight());
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode("A");
        BinaryTreeNode newNodeB = new BinaryTreeNode("B");
        BinaryTreeNode newNodeC = new BinaryTreeNode("C");
        BinaryTreeNode newNodeD = new BinaryTreeNode("D");
        BinaryTreeNode newNodeE = new BinaryTreeNode("E");
        BinaryTreeNode newNodeF = new BinaryTreeNode("F");
        BinaryTreeNode newNodeM = new BinaryTreeNode("M");
        BinaryTreeNode newNodeN = new BinaryTreeNode("N");
        BinaryTreeNode newNodeX = new BinaryTreeNode("X");
        root.setLeft(newNodeB);
        root.setRight(newNodeC);
        root.getLeft().setLeft(newNodeD);
        root.getLeft().setRight(newNodeE);
        root.getRight().setRight(newNodeF);
        root.getLeft().getRight().setLeft(newNodeM);
        root.getLeft().getRight().setRight(newNodeN);
        root.getLeft().getLeft().setRight(newNodeX);

        preOrder(root);
        getMirrorTree(root);
        System.out.println();
        preOrder(root);
    }
}
