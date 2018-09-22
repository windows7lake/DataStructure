package solution.datastructure.common;

public class TreeNode {
    public int key;
    public String data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public boolean isVisited = false;

    public TreeNode() {
    }

    public TreeNode(int key) {
        this.key = key;
    }

    public TreeNode(int key, String data) {
        this.key = key;
        this.data = data;
    }

    public TreeNode(int key, String data, TreeNode leftChild, TreeNode rightChild) {
        this.key = key;
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
