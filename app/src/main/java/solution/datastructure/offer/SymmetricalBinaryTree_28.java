package solution.datastructure.offer;

import solution.datastructure.common.BinaryTreeNode;

public class SymmetricalBinaryTree_28 {

    public static boolean isSymmetrical(BinaryTreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    public static boolean isSymmetrical(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) return true;
        if (pRoot1 == null || pRoot2 == null) return false;
        if (pRoot1.getValue() != pRoot2.getValue()) return false;
        return isSymmetrical(pRoot1.getLeft(), pRoot2.getRight())
                && isSymmetrical(pRoot1.getRight(), pRoot2.getLeft());
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode newNodeB = new BinaryTreeNode(2);
        BinaryTreeNode newNodeC = new BinaryTreeNode(2);
        BinaryTreeNode newNodeD = new BinaryTreeNode(5);
        BinaryTreeNode newNodeE = new BinaryTreeNode(7);
        BinaryTreeNode newNodeF = new BinaryTreeNode(7);
        BinaryTreeNode newNodeG = new BinaryTreeNode(5);

//        BinaryTreeNode root = null;

//        BinaryTreeNode root = new BinaryTreeNode(7);
//        BinaryTreeNode newNodeB = new BinaryTreeNode(7);
//        BinaryTreeNode newNodeC = new BinaryTreeNode(7);
//        BinaryTreeNode newNodeD = new BinaryTreeNode(7);
//        BinaryTreeNode newNodeE = new BinaryTreeNode(7);
//        BinaryTreeNode newNodeF = new BinaryTreeNode(7);

        root.setLeft(newNodeB);
        root.setRight(newNodeC);
        root.getLeft().setLeft(newNodeD);
        root.getLeft().setRight(newNodeE);
        root.getRight().setLeft(newNodeF);
        root.getRight().setRight(newNodeG);

        System.out.println(isSymmetrical(root));
    }
}
