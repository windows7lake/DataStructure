package solution.datastructure.offer;

import solution.datastructure.common.ListNode;

public class MergeSortedLists_25 {

    public static ListNode mergeSortedLists(ListNode pNode1, ListNode pNode2) {
        if (pNode1 == null) return pNode2;
        else if (pNode2 == null) return pNode1;

        ListNode pMerge = null;
        if (pNode1.value < pNode2.value) {
            pMerge = pNode1;
            pNode1 = pNode1.next;
        } else {
            pMerge = pNode2;
            pNode2 = pNode2.next;
        }
        ListNode pHead = pMerge;
        while (pNode1 != null && pNode2 != null) {
            if (pNode1.value < pNode2.value) {
                pHead.next = pNode1;
                pNode1 = pNode1.next;
            } else {
                pHead.next = pNode2;
                pNode2 = pNode2.next;
            }
            pHead = pHead.next;
        }
        if (pNode1 != null) pHead.next = pNode1;
        if (pNode2 != null) pHead.next = pNode2;
        return pMerge;
    }

    public static ListNode mergeWithRecursion(ListNode pNode1, ListNode pNode2) {
        if (pNode1 == null) return pNode2;
        else if (pNode2 == null) return pNode1;

        ListNode pMerge = null;
        if (pNode1.value < pNode2.value) {
            pMerge = pNode1;
            pMerge.next = mergeWithRecursion(pNode1.next, pNode2);
        } else {
            pMerge = pNode2;
            pMerge.next = mergeWithRecursion(pNode1, pNode2.next);
        }
        return pMerge;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();
        ListNode temp7 = new ListNode();

        head.value = 1;
        temp1.value = 3;
        temp2.value = 5;
        temp3.value = 7;

        temp4.value = 2;
        temp5.value = 4;
        temp6.value = 6;
        temp7.value = 8;

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = null;

        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = temp7;
        temp7.next = null;

        ListNode mergeList = mergeSortedLists(head, temp4);
        printList(mergeList);
    }

    //打印列表
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "  ");
            head = head.next;
        }
    }
}
