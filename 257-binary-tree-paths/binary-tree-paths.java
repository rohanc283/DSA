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
        curr += root.val;
        if (root.left == null && root.right == null) {
            res.add(curr);
        }
        curr += "->";
        solve(root.left, curr);
        solve(root.right, curr);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        solve(root, "");
        return res;
    }
}