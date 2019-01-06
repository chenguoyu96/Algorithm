package org.chenguoyu.list;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean tag = false;
        ListNode head = new ListNode(0);
        ListNode result = head;
        while (l1 != null || l2 != null) {
            int sum;
            if (l1 == null) {
                sum = l2.val;
            } else if (l2 == null) {
                sum = l1.val;
            } else {
                sum = l1.val + l2.val;
            }
            if (tag) {
                sum++;
                tag = false;
            }
            if (sum >= 10) {
                sum = sum % 10;
                tag = true;
            }
            result.next = new ListNode(sum);
            result = result.next;
            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }
        if (tag) {
            result.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(1);

        ListNode l2 = new ListNode(0);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(111);
    }
}
