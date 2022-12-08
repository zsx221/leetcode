package xhd.practice.GettingStarted;

import lombok.val;

public class Solution876 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        /**
         * .next= new ListNode(2).next= new ListNode(2)
         */
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        ListNode node = middleNode(listNode);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        int lenth = 0;
        ListNode result = head;
        while (head != null) {
            head = head.next;
            lenth++;
        }
        //lenth =7  7/2=3
        //1 2 3 4 5 6 7 8
        //lenth=8   8/2=4
        if (lenth % 2 == 1) {//单数
            lenth = lenth / 2 ;
        } else {
            lenth = lenth / 2;
        }
        int i = 0;
        while (true) {
            if (i == lenth)
                return result;
            i++;
            result = result.next;
        }
    }
}
