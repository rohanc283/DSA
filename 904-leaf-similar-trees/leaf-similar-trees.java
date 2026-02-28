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
    public void preorder(TreeNode root, List<Integer> rootLeafNodeValues) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            rootLeafNodeValues.add(root.val);
            return;
        }
        preorder(root.left, rootLeafNodeValues);
        preorder(root.right, rootLeafNodeValues);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        preorder(root1, l1);
        preorder(root2, l2);
        return l1.equals(l2);
    }
}