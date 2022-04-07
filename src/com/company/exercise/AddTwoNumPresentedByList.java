package com.company.exercise;

public class AddTwoNumPresentedByList {
    public static void main(String[] args) {
        ListNode L11 = new ListNode(9);
        ListNode L12 = new ListNode(9);
        L11.next = L12;

        ListNode L21 = new ListNode(9);
        AddTwoNumPresentedByList procedure = new AddTwoNumPresentedByList();
        ListNode result = procedure.addTwoNumbers(L11, L21);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmp = new ListNode();
        head.next = tmp;
        boolean needAdd1 = false;
        while (l1 != null && l2 != null) {

            int curlVal = calculateCurVal(l1.val + l2.val, needAdd1);
            needAdd1 = curlVal >= 10;
            curlVal = curlVal % 10;

            tmp.next = new ListNode(curlVal);
            tmp = tmp.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int curlVal = calculateCurVal(l1.val, needAdd1);
            needAdd1 = curlVal >= 10;
            curlVal = curlVal % 10;

            tmp.next = new ListNode(curlVal);
            tmp = tmp.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int curlVal = calculateCurVal(l2.val, needAdd1);
            needAdd1 = curlVal >= 10;
            curlVal = curlVal % 10;

            tmp.next = new ListNode(curlVal);
            tmp = tmp.next;

            l2 = l2.next;
        }

        if (needAdd1) {
            tmp.next = new ListNode(1);
        }

        return head.next.next;
    }

    private int calculateCurVal(int val, boolean needAdd1) {
        if (needAdd1) {
            val = val + 1;
        }
        return val;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}