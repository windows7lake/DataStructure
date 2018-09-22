package solution.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import solution.datastructure.common.TreeNode;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
        root = new TreeNode(1, "rootNode(A)");
    }

    /**
     * 创建一棵二叉树
     * <pre>
     *           A
     *     B          C
     *  D     E            F
     *   X  M   N
     *  </pre>
     *
     * @param root
     */
    public void createBinTree(TreeNode root) {
        TreeNode newNodeB = new TreeNode(2, "B");
        TreeNode newNodeC = new TreeNode(3, "C");
        TreeNode newNodeD = new TreeNode(4, "D");
        TreeNode newNodeE = new TreeNode(5, "E");
        TreeNode newNodeF = new TreeNode(6, "F");
        root.leftChild = newNodeB;
        root.rightChild = newNodeC;
        root.leftChild.leftChild = newNodeD;
        root.leftChild.rightChild = newNodeE;
        root.rightChild.rightChild = newNodeF;
        root.leftChild.rightChild.leftChild = new TreeNode(7, "M");
        root.leftChild.rightChild.rightChild = new TreeNode(8, "N");
        root.leftChild.leftChild.rightChild = new TreeNode(9, "X");
    }

    //树的高度
    public int height() {
        return height(root);
    }

    private int height(TreeNode treeNode) {
        if (treeNode == null) return 0;
        else {
            int left = height(treeNode.leftChild);
            int right = height(treeNode.rightChild);
            return left > right ? left + 1 : right + 1;
        }
    }

    //节点个数
    public int size() {
        return size(root);
    }

    private int size(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return size(treeNode.leftChild) + size(treeNode.rightChild) + 1;
    }

    public TreeNode parent(TreeNode element) {
        return (root == null || root == element) ? null : parent(root, element);
    }

    public TreeNode parent(TreeNode subTree, TreeNode element) {
        if (subTree == null)
            return null;
        if (subTree.leftChild == element || subTree.rightChild == element)
            //返回父结点地址
            return subTree;
        TreeNode p;
        //现在左子树中找，如果左子树中没有找到，才到右子树去找
        if ((p = parent(subTree.leftChild, element)) != null)
            //递归在左子树中搜索
            return p;
        else
            //递归在右子树中搜索
            return parent(subTree.rightChild, element);
    }

    public TreeNode getLeftChildNode(TreeNode element) {
        return (element != null) ? element.leftChild : null;
    }

    public TreeNode getRightChildNode(TreeNode element) {
        return (element != null) ? element.rightChild : null;
    }

    public TreeNode getRoot() {
        return root;
    }

    //在释放某个结点时，该结点的左右子树都已经释放，
    //所以应该采用后续遍历，当访问某个结点时将该结点的存储空间释放
    public void destroy(TreeNode subTree) {
        //删除根为subTree的子树
        if (subTree != null) {
            //删除左子树
            destroy(subTree.leftChild);
            //删除右子树
            destroy(subTree.rightChild);
            //删除根结点
            subTree = null;
        }
    }

    public void visit(TreeNode subTree) {
        subTree.isVisited = true;
        System.out.println("key:" + subTree.key + "--name:" + subTree.data);
    }

    //前序遍历
    public void preOrder(TreeNode subTree) {
        if (subTree == null) return;
        visit(subTree);
        preOrder(subTree.leftChild);
        preOrder(subTree.rightChild);
    }

    //中序遍历
    public void inOrder(TreeNode subTree) {
        if (subTree == null) return;
        inOrder(subTree.leftChild);
        visit(subTree);
        inOrder(subTree.rightChild);
    }

    //后序遍历
    public void postOrder(TreeNode subTree) {
        if (subTree == null) return;
        postOrder(subTree.leftChild);
        postOrder(subTree.rightChild);
        visit(subTree);
    }

    //前序遍历的非递归实现
    public void preOrderNonRec(TreeNode subTree) {
        if (subTree == null) return;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (subTree != null || !nodeStack.isEmpty()) {
            if (subTree != null) {
                visit(subTree);
                nodeStack.push(subTree);
                subTree = subTree.leftChild;
            } else {
                subTree = nodeStack.pop();
                subTree = subTree.rightChild;
            }
        }
    }

    //中序遍历的非递归实现
    public void inOrderNonRec(TreeNode subTree) {
        if (subTree == null) return;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (subTree != null || !nodeStack.isEmpty()) {
            if (subTree != null) {
                nodeStack.push(subTree);
                subTree = subTree.leftChild;
            } else {
                subTree = nodeStack.pop();
                visit(subTree);
                subTree = subTree.rightChild;
            }
        }
    }

    //后序遍历的非递归实现
    public void postOrderNonRec(TreeNode subTree) {
        if (subTree == null) return;
        Stack<TreeNode> nodeStack = new Stack<>();
        Vector<TreeNode> vector = new Vector<>();
        nodeStack.push(subTree);
        while (!nodeStack.isEmpty()) {
            subTree = nodeStack.pop();
            vector.add(subTree);
            if (subTree.leftChild != null) nodeStack.push(subTree.leftChild);
            if (subTree.rightChild != null) nodeStack.push(subTree.rightChild);
        }
        for (int i = vector.size() - 1; i >= 0; i--) {
            visit(vector.elementAt(i));
        }
    }

    //后序遍历的非递归实现
    public void postOrderNonRec2(TreeNode subTree) {
        if (subTree == null) return;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode last = subTree;
        while (subTree != null) {
            for (; subTree.leftChild != null; subTree = subTree.leftChild) {
                nodeStack.push(subTree);
            }
            while (subTree.rightChild == null || subTree.rightChild == last) {
                visit(subTree);
                last = subTree;
                if (nodeStack.isEmpty()) return;
                subTree = nodeStack.pop();
            }
            nodeStack.push(subTree);
            subTree = subTree.rightChild;
        }
    }

    //层次遍历
    public void levelIterator(TreeNode subTree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(subTree);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                visit(t);
            }
            if (t.leftChild != null) {
                queue.offer(t.leftChild);
            }
            if (t.rightChild != null) {
                queue.offer(t.rightChild);
            }
        }
    }

    //测试
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinTree(bt.root);
        System.out.println("the size of the tree is " + bt.size());
        System.out.println("the height of the tree is " + bt.height());

        System.out.println("*******(前序遍历)遍历*****************");
        bt.preOrder(bt.root);

        System.out.println("*******(中序遍历)遍历*****************");
        bt.inOrder(bt.root);

        System.out.println("*******(后序遍历)遍历*****************");
        bt.postOrder(bt.root);

        System.out.println("***非递归实现****(前序遍历)遍历*****************");
        bt.preOrderNonRec(bt.root);

        System.out.println("***非递归实现****(中序遍历)遍历*****************");
        bt.inOrderNonRec(bt.root);

        System.out.println("***非递归实现****(后序遍历)遍历*****************");
        bt.postOrderNonRec2(bt.root);

        System.out.println("层次遍历*****************");
        bt.levelIterator(bt.root);
    }
}
