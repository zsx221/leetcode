package xhd.practice;

public class offer25_2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode flag=new ListNode(-1);
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode pre=flag;
        while(l1!=null&&l2!=null){
            ListNode now=new ListNode(-1);
            pre.next=now;
            if(l1.val<=l2.val)
            {
                pre.next=l1;
                l1=l1.next;
            }
            else
            {
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return flag.next;
    }

}
