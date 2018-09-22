package solution.datastructure.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import solution.datastructure.common.ListNode;

public class PrintListInReversedOrder_06 {

    public static void printListReverseByStack(ListNode node) {
        Stack<ListNode> nodeStack = new Stack<>();
        while (node != null) {
            nodeStack.push(node);
            node = node.next;
        }
        while (!nodeStack.empty()) {
            System.out.print(nodeStack.pop().value + ", ");
        }
    }

    public static void printListReverseByRecursion(ListNode node) {
        if (node == null) return;
        printListReverseByRecursion(node.next);
        System.out.print(node.value + ", ");
    }

    public static void main(String[] args) {
        List<ListNode> nodeList = new ArrayList<>();
        for (int i = 0; i < 8459; i++) {
            ListNode node = new ListNode();
            node.value = i;
            nodeList.add(node);
        }
        for (int i = 0; i < nodeList.size(); i++) {
            if (i == nodeList.size() - 1) nodeList.get(i).next = null;
            else nodeList.get(i).next = nodeList.get(i + 1);
        }

        printListReverseByStack(nodeList.get(0));
        System.out.println();
        printListReverseByRecursion(nodeList.get(0));
    }
}
