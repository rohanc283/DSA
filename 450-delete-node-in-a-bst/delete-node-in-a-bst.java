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
    private TreeNode helper(TreeNode root) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        TreeNode right = root.right;
        TreeNode left = root.left;
        TreeNode leftRight = left;
        while (leftRight.right != null)
            leftRight = leftRight.right;
        leftRight.right = right;
        return left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        TreeNode head = root;
        TreeNode curr = root;
        if (curr.val == key) {
            return helper(root);
        }
        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return head;
    }
}