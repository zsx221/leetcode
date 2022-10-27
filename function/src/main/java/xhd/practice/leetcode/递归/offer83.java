package xhd.practice.leetcode.递归;

/**
 * 给定一个已排序的链表的头 head ，
 * 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 */
public class offer83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return head;
        ListNode node=head;//傀儡节点
        while (head.next!=null)
        {
            if (head.val==head.next.val)
                head.next=head.next.next;
            else
                head=head.next;
        }
        return node;
    }
     public class ListNode { int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
