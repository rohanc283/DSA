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
    int res = 0;

    public void inorderTraversal(TreeNode root, int low, int high) {
        if (root == null)
            return;
        inorderTraversal(root.left, low, high);
        if (root.val >= low && root.val <= high)
            res += root.val;
        inorderTraversal(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        inorderTraversal(root, low, high);
        return res;
    }
}