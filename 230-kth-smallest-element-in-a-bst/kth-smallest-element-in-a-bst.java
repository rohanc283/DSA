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
    int res = -1;
    int kth = 0;

    private void solve(TreeNode root) {
        if (root == null)
            return;
        solve(root.left);
        kth--;
        if (kth == 0) {
            res = root.val;
        }
        solve(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        solve(root);
        return res;
    }
}