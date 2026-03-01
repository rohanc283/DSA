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
    public boolean checkBSTProperty(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null)
            return true;
        if (minNode != null) {
            if (root.val <= minNode.val)
                return false;
        }
        if (maxNode != null) {
            if (root.val >= maxNode.val)
                return false;
        }
        return checkBSTProperty(root.left, minNode, root) && checkBSTProperty(root.right, root, maxNode);
    }

    public boolean isValidBST(TreeNode root) {
        return checkBSTProperty(root, null, null);
    }
}