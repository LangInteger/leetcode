package com.company.exercise;

public class RemoveNthFromEnd {

    /**
     * dummy 1 2 3 4 5
     * 2
     *
     * count = 5
     * target = 3
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        int length = 0;
        while (head != null) {
            head = head.next;
            length = length + 1;
        }

        ListNode cur = dummy;
        for (int index = 0; index < length - n; index++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;


        int n = 2;

        RemoveNthFromEnd procedure = new RemoveNthFromEnd();
        procedure.removeNthFromEnd(one, n);
    }
}
