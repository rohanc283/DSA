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
    List<String> res = new ArrayList<>();

    public void solve(TreeNode root, String curr) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            res.add(curr + root.val);
            return;
        }

        solve(root.left, curr + root.val + "->");
        solve(root.right, curr + root.val + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        solve(root, "");
        return res;
    }
}