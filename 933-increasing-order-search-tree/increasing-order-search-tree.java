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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = null;
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.left == null) {
                if (res == null)
                    res = curr;
                if (prev != null) {
                    prev.right = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode left = curr.left;
                TreeNode leftRight = left;
                while (leftRight != null && leftRight.right != null)
                    leftRight = leftRight.right;
                leftRight.right = curr;
                curr.left = null;
                curr = left;
            }
        }
        return res;
    }
}