package com.company.exercise;

public class _21MergeTwoList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyTmp = new ListNode(0);
        ListNode dummyResult = new ListNode(0, dummyTmp);

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                dummyTmp.next = list2;
                list2 = list2.next;
            } else {
                dummyTmp.next = list1;
                list1 = list1.next;
            }
            dummyTmp = dummyTmp.next;
        }

        if (list1 != null) {
            dummyTmp.next = list1;
        }

        if (list2 != null) {
            dummyTmp.next = list2;
        }

        return dummyResult.next.next;
    }
}
