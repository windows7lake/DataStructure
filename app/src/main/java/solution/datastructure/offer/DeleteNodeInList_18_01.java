package solution.datastructure.offer;

import solution.datastructure.common.ListNode;

public class DeleteNodeInList_18_01 {

    private static void deleteNode(ListNode head, ListNode delete) {
        if (head == null || delete == null) return;

        if (head == delete && head.next == null)
            head = null;
        else {
            if (delete.next == null) {
                ListNode tmp = head;
                while (tmp.next != delete) {
                    tmp = tmp.next;
                }
                tmp.next = null;
            } else {
                delete.value = delete.next.value;
                delete.next = delete.next.next;
            }
        }
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

        head.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 4;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = null;

        System.out.println("删除前的链表：");
        printList(head);

        System.out.println("-----------------------");

        deleteNode(head, temp2);       //执行删除操作
        System.out.println("删除后的链表：");
        printList(head);
    }

}
