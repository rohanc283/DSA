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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public void solve(TreeNode root, int targetSum, int currSum) {
        if (root == null)
            return;
        currSum += root.val;
        curr.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                res.add(new ArrayList<>(curr));
            }
            curr.remove(curr.size() - 1);
            return;
        }
        solve(root.left, targetSum, currSum);
        solve(root.right, targetSum, currSum);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solve(root, targetSum, 0);
        return res;
    }
}