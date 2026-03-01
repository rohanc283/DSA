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
    private TreeNode solve(int[] nums, int s, int e) {
        if (s > e)
            return null;
        int m = s + (e - s) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = solve(nums, s, m - 1);
        root.right = solve(nums, m + 1, e);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }
}