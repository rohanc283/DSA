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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ListNode listHead = null;

    private TreeNode createTree(int n) {
        if (listHead == null || n <= 0)
            return null;
        TreeNode left = createTree(n / 2);
        TreeNode root = new TreeNode(listHead.val);
        root.left = left;
        listHead = listHead.next;
        root.right = createTree(n - (n / 2) - 1);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        listHead = head;
        return createTree(n);
    }
}