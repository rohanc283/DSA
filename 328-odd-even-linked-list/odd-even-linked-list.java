class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;

        ListNode curr = head;
        int index = 1;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null;

            if ((index & 1) == 1) {
                if (oddHead == null) {
                    oddHead = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }
            } else {
                if (evenHead == null) {
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }

            curr = next;
            index++;
        }

        if (oddTail != null) {
            oddTail.next = evenHead;
        }

        return oddHead;
    }
}