package solution.datastructure.offer;

import solution.datastructure.common.ListNode;

public class EntryNodeInListLoop_23 {

    public static ListNode meetingNode(ListNode pHead) {
        if (pHead == null) return null;

        ListNode pSlow = pHead.next;
        if (pSlow == null) return null;

        ListNode pFast = pSlow.next;
        while (pSlow != null && pFast != null) {
            if (pFast == pSlow) return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null) pFast = pFast.next;
        }
        return null;
    }

    public static ListNode getEntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode  = meetingNode(pHead);
        if (meetingNode == null) return null;

        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode) {
            pNode1 = pNode1.next;
            ++nodesInLoop;
        }

        pNode1 = pHead;
        for (int i = 0; i < nodesInLoop; i++)
            pNode1 = pNode1.next;

        ListNode pNode2 = pHead;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
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
        temp5.next = temp2;

        ListNode resultNode = getEntryNodeOfLoop(head);
        if (resultNode != null) {
            System.out.println(resultNode.value);
        } else {
            System.out.println("您输入的参数有误！");
        }
    }
}
