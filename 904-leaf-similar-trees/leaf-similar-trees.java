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
        List<Integer> root1LeafNodeValues = new ArrayList<>();
        List<Integer> root2LeafNodeValues = new ArrayList<>();
        preorder(root1, root1LeafNodeValues);
        preorder(root2, root2LeafNodeValues);
        if (root1LeafNodeValues.size() != root2LeafNodeValues.size())
            return false;
        for (int i = 0; i < root2LeafNodeValues.size(); i++) {
            if (!root1LeafNodeValues.get(i).equals(root2LeafNodeValues.get(i))) {
                return false;
            }
        }
        return true;
    }
}