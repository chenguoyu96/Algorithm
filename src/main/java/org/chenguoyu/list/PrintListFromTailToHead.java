package org.chenguoyu.list;

import java.util.ArrayList;

public class PrintListFromTailToHead {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        printListFromTailToHead(listNode, list);
        return list;
    }

    private void printListFromTailToHead(ListNode listNode, ArrayList<Integer> list) {
        if (listNode == null) {
            return;
        }
        printListFromTailToHead(listNode.next, list);
        list.add(listNode.val);
    }


}
