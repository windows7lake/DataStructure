package solution.datastructure.offer;

import solution.datastructure.common.BinaryTreeNode2;

public class SubstructureInTree_26 {

    private static boolean hasSubTree(BinaryTreeNode2 pRoot1, BinaryTreeNode2 pRoot2) {
        boolean result = false;
        if (pRoot1 != null && pRoot2 != null) {
//            if (Double.doubleToLongBits(pRoot1.getValue()) == Double.doubleToLongBits(pRoot2.getValue()))
            if (pRoot1.getValue() == pRoot2.getValue())
                result = doesTree1HaveTree2(pRoot1, pRoot2);
            if (!result)
                result = hasSubTree(pRoot1.getLeft(), pRoot2);
            if (!result)
                result = hasSubTree(pRoot1.getRight(), pRoot2);
        }
        return result;
    }

    private static boolean doesTree1HaveTree2(BinaryTreeNode2 pRoot1, BinaryTreeNode2 pRoot2) {
        if (pRoot2 == null) return true;
        if (pRoot1 == null) return false;
//        if (Double.doubleToLongBits(pRoot1.getValue()) != Double.doubleToLongBits(pRoot2.getValue()))
        if (pRoot1.getValue() != pRoot2.getValue())
            return false;
        return doesTree1HaveTree2(pRoot1.getLeft(), pRoot2.getLeft())
                && doesTree1HaveTree2(pRoot1.getRight(), pRoot2.getRight());
    }

    public static void main(String[] args) {
        BinaryTreeNode2 head = new BinaryTreeNode2();
        BinaryTreeNode2 temp1 = new BinaryTreeNode2();
        BinaryTreeNode2 temp2 = new BinaryTreeNode2();
        BinaryTreeNode2 temp3 = new BinaryTreeNode2();
        BinaryTreeNode2 temp4 = new BinaryTreeNode2();
        BinaryTreeNode2 temp5 = new BinaryTreeNode2();
        BinaryTreeNode2 temp6 = new BinaryTreeNode2();
        BinaryTreeNode2 temp7 = new BinaryTreeNode2();
        BinaryTreeNode2 temp11 = new BinaryTreeNode2();
        BinaryTreeNode2 temp12 = new BinaryTreeNode2();
        BinaryTreeNode2 temp13 = new BinaryTreeNode2();

        head.setValue(1);
        temp1.setValue(2);
        temp2.setValue(3.01);
        temp3.setValue(4);
        temp4.setValue(5);
        temp5.setValue(6.000);
        temp6.setValue(7);
        temp7.setValue(8);

        temp11.setValue(3.01);
        temp12.setValue(6.00000000);
        temp13.setValue(7);

        head.setLeft(temp1);
        head.setRight(temp2);
        temp1.setLeft(temp3);
        temp1.setRight(temp4);
        temp2.setLeft(temp5);
        temp2.setRight(temp6);
        temp3.setLeft(temp7);

        temp11.setLeft(temp12);
        temp11.setRight(temp13);

        System.out.println("hasSubTree: " + hasSubTree(head, temp11));
    }
}
