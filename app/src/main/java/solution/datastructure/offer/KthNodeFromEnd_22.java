package solution.datastructure.offer;

import solution.datastructure.common.ListNode;

public class KthNodeFromEnd_22 {

    public static ListNode getKthNodeFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) return null;

        ListNode ahead = head;
        ListNode behind = head;

        for (int i = 0; i < k - 1; i++) {
            if (ahead.next == null) return null;
            ahead = ahead.next;
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
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
        temp3.value = 4;
        temp4.value = 5;
        temp5.value = 6;
        temp6.value = 7;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = null;

        ListNode resultNode = getKthNodeFromEnd(head, 3);
        if (resultNode != null) {
            System.out.println(resultNode.value);
        } else {
            System.out.println("您输入的参数有误！");
        }
    }
}
