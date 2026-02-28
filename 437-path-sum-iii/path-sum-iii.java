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
    List<Integer> curr = new ArrayList<>();
    int[] res = new int[1];

    private void solve(TreeNode root, int targetSum) {
        if (root == null)
            return;
        curr.add(root.val);
        int n = curr.size();
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += curr.get(i);
            if (sum == targetSum) {
                res[0]++;
            }
        }
        solve(root.left, targetSum);
        solve(root.right, targetSum);
        curr.remove(n - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        solve(root, targetSum);
        return res[0];
    }
}