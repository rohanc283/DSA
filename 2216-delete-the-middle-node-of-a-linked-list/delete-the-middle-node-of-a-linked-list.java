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
    public int length(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        return n;
    }

    public ListNode deleteMiddle(ListNode head) {
        int l = length(head);
        int n = l / 2;
        if (n == 0)
            return null;
        int i = 0;
        ListNode curr = head;
        while (i < n - 1) {
            curr = curr.next;
            i++;
        }
        ListNode middle = curr.next;
        ListNode next = middle == null ? null : middle.next;
        curr.next = next;
        return head;
    }
}