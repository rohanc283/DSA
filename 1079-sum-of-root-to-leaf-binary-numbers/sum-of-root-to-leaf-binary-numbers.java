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
    public void solve(TreeNode root, int num, int[] res) {
        if (root == null)
            return;
        num = num * 2 + root.val;
        if (root.left == null && root.right == null) {
            res[0] += num;
            return;
        }
        solve(root.left, num, res);
        solve(root.right, num, res);
    }

    public int sumRootToLeaf(TreeNode root) {
        int[] res = new int[1];
        res[0] = 0;
        solve(root, 0, res);
        return res[0];
    }
}