/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null, evenHead = null, oddTail = null, evenTail = null, curr = head;
        int i = 1;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null;
            if (i % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            i++;
            curr = next;
        }

        if (oddTail != null)
            oddTail.next = evenHead;
        return oddHead;

    }
}