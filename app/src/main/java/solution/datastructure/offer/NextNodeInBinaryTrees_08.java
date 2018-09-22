package solution.datastructure.offer;

import solution.datastructure.common.BinaryTreeNode;

public class NextNodeInBinaryTrees_08 {

    public static BinaryTreeNode getNextNode(BinaryTreeNode root, BinaryTreeNode search) {
        if (root == null || search == null) return null;

        BinaryTreeNode tmpNode;
        if (search.getRight() != null) {
            tmpNode = search.getRight();
            while (tmpNode.getLeft() != null) {
                tmpNode = tmpNode.getLeft();
            }
            return tmpNode;
        }

        if (search.getParent() == null) return null;
        if (search == search.getParent().getLeft()) {
            return search.getParent();
        }

        tmpNode = search.getParent();
        while (tmpNode.getParent() != null) {
            if (tmpNode.getParent().getLeft() == tmpNode) {
                return tmpNode.getParent();
            }
            tmpNode = tmpNode.getParent();
        }

        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left1 = new BinaryTreeNode(2);
        BinaryTreeNode left2 = new BinaryTreeNode(4);
        BinaryTreeNode left3 = new BinaryTreeNode(7);
        BinaryTreeNode right1 = new BinaryTreeNode(3);
        BinaryTreeNode right2 = new BinaryTreeNode(5);
        BinaryTreeNode right3 = new BinaryTreeNode(6);
        BinaryTreeNode right4 = new BinaryTreeNode(8);
        root.setParent(null);
        root.setLeft(left1);
        root.setRight(right1);
        left1.setParent(root);
        left1.setLeft(left2);
        left1.setRight(null);
        left2.setParent(left1);
        left2.setLeft(null);
        left2.setRight(left3);
        left3.setParent(left2);
        left3.setLeft(null);
        left3.setRight(null);
        right1.setParent(root);
        right1.setLeft(right2);
        right1.setRight(right3);
        right2.setParent(right1);
        right2.setLeft(null);
        right2.setRight(null);
        right3.setParent(right1);
        right3.setLeft(right4);
        right3.setRight(null);
        right4.setParent(right3);
        right4.setLeft(null);
        right4.setRight(null);
        System.out.println(getNextNode(root, root));    // 1
        System.out.println(getNextNode(root, left1));   // 2
        System.out.println(getNextNode(root, left2));   // 4
        System.out.println(getNextNode(root, left3));   // 7
        System.out.println(getNextNode(root, right1));  // 3
        System.out.println(getNextNode(root, right2));  // 5
        System.out.println(getNextNode(root, right3));  // 6
        System.out.println(getNextNode(root, right4));  // 8
        inOrder(root);
    }

    //中序遍历
    public static void inOrder(BinaryTreeNode subTree) {
        if (subTree == null) return;
        inOrder(subTree.getLeft());
        System.out.print(subTree.getValue() + ", ");
        inOrder(subTree.getRight());
    }
}
