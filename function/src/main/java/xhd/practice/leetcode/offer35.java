package xhd.practice.leetcode;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *
 */
public class offer35 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node head=new Node(7);
        head.next=new Node(13);
        head.next.random=head;
        copyRandomList(head);
    }
    public static Node copyRandomList(Node head) {
        if (head==null||head.next==null)
            return head;
        Node node=new Node(1);
        Node result=node;
        while (head!=null){
            node.next=head;
            node.next.val=head.val;
            node.next.random=head.random;
            node=node.next;
            head=head.next;
        }
        return result.next;
    }
}
