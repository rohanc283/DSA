/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == head)
                return head;
            fast = fast.next;
            if (fast == slow)
                break;
        }
        slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == slow)
                return slow;
            fast = fast.next;
        }
        return null;
    }
}