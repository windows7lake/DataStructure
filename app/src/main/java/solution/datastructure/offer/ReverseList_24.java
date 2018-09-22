package solution.datastructure.offer;

import solution.datastructure.common.ListNode;

public class ReverseList_24 {

    public static ListNode reverseList(ListNode pHead) {
        ListNode pReversedHead = null;
        ListNode pNode = pHead;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) pReversedHead = pNode;

            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }

        return pReversedHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();

        head.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 4;
        temp4.value = 5;
        temp5.value = 6;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = null;

        System.out.println("反转前：");
        printList(head);
        System.out.println();
        //执行反转操作
        ListNode reverseHead = reverseList(head);
//        ListNode reverseHead = reverseList(null);
        printList(reverseHead);

    }

    //打印列表
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "  ");
            head = head.next;
        }
    }
}
