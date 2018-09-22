package solution.datastructure.offer;

import java.util.Stack;

import solution.datastructure.common.BinaryTreeNode;

public class PrintTreesInZigzag_32_03 {

    public static void printTree(BinaryTreeNode root) {
        if (root == null) return;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        boolean isReverse = false;

        stack1.push(root);
        while (!stack1.empty() || !stack2.empty()) {
            if (isReverse) {
                BinaryTreeNode pNode2 = stack2.pop();
                System.out.print(pNode2.getStr());
                if (pNode2.getRight() != null) stack1.push(pNode2.getRight());
                if (pNode2.getLeft() != null) stack1.push(pNode2.getLeft());
                if (stack2.empty()) {
                    System.out.println();
                    isReverse = false;
                }
            } else {
                BinaryTreeNode pNode1 = stack1.pop();
                System.out.print(pNode1.getStr());
                if (pNode1.getLeft() != null) stack2.push(pNode1.getLeft());
                if (pNode1.getRight() != null) stack2.push(pNode1.getRight());
                if (stack1.empty()) {
                    System.out.println();
                    isReverse = true;
                }
            }
        }
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

        printTree(root);
    }
}
