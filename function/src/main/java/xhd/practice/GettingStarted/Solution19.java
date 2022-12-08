package xhd.practice.GettingStarted;

import lombok.val;

public class Solution19 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        listNode = removeNthFromEnd(listNode, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int lenth = 0;
        ListNode right = head;
        while (head != null) {
            head = head.next;
            lenth++;
        }
        if (lenth==1)
            return head;
        head = right;

        int south = lenth - n;
        int i = 0;
        while (true) {
            if (i == south - 1) {
                head.next = head.next.next;
                break;
            }else if (i==south){
                head= head.next;
                return head;
            }
            i++;
            head = head.next;
        }
        return right;

    }

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
}
