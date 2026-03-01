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
    int idx = 0;

    private TreeNode createTree(int[] preorder, int maxi) {
        if (idx >= preorder.length)
            return null;
        if (preorder[idx] > maxi)
            return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = createTree(preorder, root.val);
        root.right = createTree(preorder, maxi);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return createTree(preorder, Integer.MAX_VALUE);
    }
}