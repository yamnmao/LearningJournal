package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists23 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val=val;this.next=next;}
    }

    public ListNode mergeKLists(ListNode[] lists){
        //检查空列表的情况
        if (lists.length == 0) return null;
        //创建了一个虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        // 创建了一个优先级队列 pq，容量为 lists.length，意味着队列的容量足以容纳所有链表的头结点。
        // 比较器 (a, b) -> (a.val - b.val) 确定了队列的排序规则，即节点值小的 ListNode 先出队。
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while(!pq.isEmpty()){
            //获取最小节点
            ListNode node = pq.poll();
            p.next = node;
            if(node.next!=null){
                pq.add(node.next);
            }
            //move p pointer
            p=p.next;
        }
        return dummy.next;
    }
}
