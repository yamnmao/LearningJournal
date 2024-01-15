package LinkedList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;
public class ReversedLinkedList {
    public ListNode head;
    public void insertNode(int val) {
        ListNode node = new ListNode(val);
        if (this.head != null) {
            node.next = head;
        }
        this.head = node;
    }
    public static void printSinglyLinkedList(ListNode node, String sep)
            throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.val) + sep);
            node = node.next;
        }
    }
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode current = head;

            while(current != null)
            {
                ListNode next = current.next;
                current.next=prev;
                prev=current;
                current=next;
            }

            return prev;
        }
        public ListNode recursiveList(ListNode node){
            if(node == null || node.next == null) {
                return node;
            }else {
                //在12345的例子中，当node=4，next的时候，进入recursive method，然后node.next指向5，null，符合if条件
                //return node = 5，null，ListNode reversed = 5，null
                ListNode reversed = recursiveList(node.next);
                //这个时候node是4，next
                node.next.next = node;
                node.next = null;
                //这一步return后，根据visualizer，会回到List Node reversed那一步，回到node=3，next时的递归
                //还有一个问题就是variable passing to variable，同时指向一个object，object变了variable也会变，所以return reversed
                return reversed;
            }
        }
        public static void main(String[] args) throws IOException {
         ReversedLinkedList llist = new ReversedLinkedList();
         llist.insertNode(5);
         llist.insertNode(4);
         llist.insertNode(3);
         llist.insertNode(2);
         llist.insertNode(1);
         System.out.println("Given linked list:");
         printSinglyLinkedList(llist.head, " ");
         System.out.println();

        System.out.println("Reverse linked list by iteration:");
         printSinglyLinkedList(llist.reverseList(llist.head), " ");
         System.out.println();

       /* System.out.println("Reverse linked list by recursive:");
        printSinglyLinkedList(llist.recursiveList(llist.head)," ");*/
        }

}
