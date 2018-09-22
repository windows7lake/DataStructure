package solution.datastructure.offer;

import java.util.LinkedList;
import java.util.Queue;

import solution.datastructure.common.BinaryTreeNode;

public class PrintTreeFromTopToBottom_32_01 {

    public static void printTree(BinaryTreeNode root) {
        if (root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode pNode = queue.poll();
            System.out.print(pNode.getStr());

            if (pNode.getLeft() != null)
                queue.add(pNode.getLeft());
            if (pNode.getRight() != null)
                queue.add(pNode.getRight());
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
