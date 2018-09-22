package solution.datastructure.common;

public class BinaryTreeNode2 {

    private double value;
    private BinaryTreeNode2 left;
    private BinaryTreeNode2 right;

    public BinaryTreeNode2() {
    }

    public BinaryTreeNode2(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public BinaryTreeNode2 getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode2 left) {
        this.left = left;
    }

    public BinaryTreeNode2 getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode2 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
