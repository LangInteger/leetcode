package com.company.exercise;

public class _23MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode tmp = null;

        for (int index = 0; index < lists.length; index++) {
            tmp = merge2Lists(tmp, lists[index]);
        }

        return tmp;
    }

    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode tmp = new ListNode(0);
        ListNode result = new ListNode(0, tmp);

        while (list1 != null & list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }

            tmp = tmp.next;
        }

        if (list1 != null) {
            tmp.next = list1;
        }

        if (list2 != null) {
            tmp.next = list2;
        }

        return result.next.next;
    }
}
