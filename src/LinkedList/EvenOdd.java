package LinkedList;

/**
 *Implement the method evenOdd by destructively changing the ordering of a given
 * IntList so that even indexed links precede odd indexed links.
 * For instance, if lst is defined as IntList.list(0, 3, 1, 4, 2, 5), evenOdd(lst)
 * would modify lst to be IntList.list(0, 1, 2, 3, 4, 5).
 * Group all the nodes with even indices together followed by the nodes with odd indices,
 * and return the reordered list.
 */
public class EvenOdd {
    /**
     * Study Material: https://www.youtube.com/watch?v=bfAOCQPhUPw
     * Logic: 1. connect each odd link to the next odd link, even link to the next even link
     * Example: 0->2->1->3
     *    index:0  1  2  3
     *  output: 0->1->2->3
     *   index: 0  2  1  3 (index grouped according to even and odd
     *   2. Once get to the end, connect the last even link to the first odd link
     *
     * @lst also = even List, it will be 0->1
     * @oddList = lst.next , it will be 2->3
     * @linkHead = lst.next =2; linkHead will link two list finally(0->1->2->3)
     */
    public static void evenOdd(ListNode lst) {
        //always do the initial check on list and rest
        if (lst == null || lst.next == null) {
            return;
        }
        //we will separate them. one head for even linked list
        ListNode oddList = lst.next;
        ListNode linkHead = lst.next;
        while (lst.next != null && oddList.next != null) {
            /**take example of 03142,
             *         0->3->1->4->2
             * lst     0->3->1->4->2
             *oddlist  3->1->4->2
             *LinkHead 3->1->4->2
             */
            lst.next = lst.next.next;
            /**        0->3->1->4->2
             * lst     0>1->4->2
             *oddlist  3->1->4->2
             *LinkHead 3->1->4->2
             */
            oddList.next = oddList.next.next;
            /**        0->3->1->4->2
             * lst     0—>1->4->2.null
             *oddlist  3->4->2.null
             *LinkHead 3->4->2.null
             */
           lst = lst.next;
            /**        0->3->1->4->2
             * lst     0—>1(lst)->4->2.null
             */
           oddList = oddList.next;
            /**        0->3->1->4->2
             *oddlist  3->4(oddlist)->2.null
             *LinkHead 3->4->2
             */
            /*
              odd list will end first.When oddList point to 4, it will go through the 4.next=4.next.next
              as we know the 4.next.next=2.null,so it will end. After oddList=oddList.next
              odd list will be: 3->4->null(oddlist) and that's why we need a linkhead.
              linkHead will be: 3->4->null (they all refer a same address)
              even list end: 0—>1->2(lst).null, lst.next=null
             */
        }
        //since lst.next = null, oddlist.next = null, we jump out of the loop.
        lst.next = linkHead;
        //0—>1->2(lst)->3->4->null
    }
}

