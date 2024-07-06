package LinkedList;

import java.util.List;

public class PartitionList86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, MergeTwoSortedLists21.ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        //store dummy head for the list less than x
        ListNode dummy1= new ListNode(-1);
        //store dummy head for the list bigger than x
        ListNode dummy2 = new ListNode(-1);
        //p1 points to dummy1, p2 points to dummy2
        ListNode p1 = dummy1,p2 = dummy2;
        //p points to head
        ListNode p = head;
        while(p!=null){
            if(p.val>=x){
                p2.next=p;
                p2=p2.next;
            }else{
                p1.next=p;
                p1=p1.next;
            }
            // 不能直接让 p 指针前进:p = p.next
            // 断开原链表中的每个节点的 next 指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        //p1在dummy1链表的末尾，指向dummy2链表next（dummy2开头是-1）
        p1.next = dummy2.next;
        return dummy1.next;
    }

}
