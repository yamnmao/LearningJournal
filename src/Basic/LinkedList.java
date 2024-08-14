package Basic;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}

public class LinkedList {
    //transfer array to linkedList
    ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
    // Main method to run the code
    public static void main(String[] args) {
        //Create
        LinkedList list = new LinkedList();
        ListNode head = list.createLinkedList(new int[]{1, 2, 3, 4, 5});

        // 遍历单链表Traversing the singly linked list
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val+"->");
        }
        System.out.println();

        //Update
        //1. 在单链表头部插入新节点0
        ListNode newHead = new ListNode(0);//0 is val
        newHead.next = head;
        head = newHead;//move head pointer to newHead

        //2. 在单链表尾部插入新元素
        ListNode lastHead = head;
        while(lastHead.next!=null){
            lastHead= lastHead.next;
        }
        //lastHead is the last one (5), add new element to p
        lastHead.next =new ListNode(6);

        //3. 在单链表中间插入新元素
            // 在第 3 个节点后面插入一个新节点 66
            // 先要找到前驱节点，即第 3 个节点
        ListNode middleHead = head;
        for (int i = 0; i < 2; i++) {
            middleHead = middleHead.next;
        }// 此时 middleHead 指向第 3 个节点
        // 组装新节点的后驱指针
        ListNode newNode = new ListNode(66);
        newNode.next = middleHead.next;
        middleHead.next=newNode;

        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val+"->");
        }
        System.out.println();

        //Delete
        // 1.在单链表删除第 4 个节点，要操作前驱节点
        ListNode deleteMiddle = head;
        for (int i = 0; i < 2; i++) {
            deleteMiddle = deleteMiddle.next;
        }// 此时指向第 3 个节点，即要删除节点的前驱节点
        // 把第 4 个节点从链表中摘除
        deleteMiddle.next = deleteMiddle.next.next;

        // 2.在单链表删除尾节点
        ListNode deleteTail = head;
        // 找到倒数第二个节点
        while (deleteTail.next.next != null) {
            deleteTail = deleteTail.next;
        }// 此时指向倒数第二个节点
        // 把尾节点从链表中摘除
        deleteTail.next = null;

        //3.在单链表删除头节点
        head = head.next;

        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val+"->");
        }
        System.out.println();
    }
}