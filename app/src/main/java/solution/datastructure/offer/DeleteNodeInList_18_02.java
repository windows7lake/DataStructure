package solution.datastructure.offer;

import solution.datastructure.common.ListNode;

public class DeleteNodeInList_18_02 {

    private static ListNode deleteDuplication(ListNode head) {
        if (head == null) return null;

        ListNode preNode = new ListNode(); // 前一个节点
        ListNode tmp = preNode;
        preNode.next = head;
        ListNode curNode = head; // 当前节点

        while (curNode != null) {
            // 判断是否存在重复节点，是否应该删除
            if (curNode.next != null && curNode.value == curNode.next.value) {
                while (curNode.next != null && curNode.value == curNode.next.value) {
                    curNode = curNode.next;
                }
                preNode.next = curNode.next;
            } else {
                preNode = curNode;
            }
            curNode = curNode.next;
        }

        return tmp.next;
    }

    private static void printList(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + ", ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();

        head.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 3;
        temp4.value = 4;
        temp5.value = 4;
        temp6.value = 5;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = null;

        System.out.println("删除前的链表：");
        printList(head);

        System.out.println("-----------------------");
        ListNode newHead = deleteDuplication(head);       //执行删除操作

        System.out.println("删除后的链表：");
        printList(newHead);
    }

}
