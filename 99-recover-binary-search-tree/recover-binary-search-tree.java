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
    TreeNode first = null, middle = null, last = null, prev = null;

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    private void swap(TreeNode root1, TreeNode root2) {
        int temp = root1.val;
        root1.val = root2.val;
        root2.val = temp;
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        if (first != null) {
            if (last != null) {
                swap(first, last);
            } else {
                swap(first, middle);
            }
        }
    }
}