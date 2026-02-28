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
    private void solve(TreeNode root, int curr, int[] res) {
        if (root == null)
            return;
        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null) {
            res[0] += curr;
            return;
        }
        solve(root.left, curr, res);
        solve(root.right, curr, res);
    }

    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        solve(root, 0, res);
        return res[0];
    }
}