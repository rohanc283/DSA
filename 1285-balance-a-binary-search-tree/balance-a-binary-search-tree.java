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
    List<Integer> inorder = new ArrayList<>();

    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    private TreeNode createTree(int s, int e) {
        if (s > e)
            return null;
        int m = s + (e - s) / 2;
        TreeNode root = new TreeNode(inorder.get(m));
        root.left = createTree(s, m - 1);
        root.right = createTree(m + 1, e);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return createTree(0, inorder.size() - 1);
    }
}