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

    private void solve1(TreeNode root, int targetSum) {
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
        solve1(root.left, targetSum);
        solve1(root.right, targetSum);
        curr.remove(n - 1);
    }

    public int sol1(TreeNode root, int targetSum) {
        solve1(root, targetSum);
        return res[0];
    }

    Map<Long, Integer> prefix = new HashMap<>();

    public int solve2(TreeNode root, int targetSum, long currSum) {
        if (root == null)
            return 0;

        currSum += root.val;
        int count = prefix.getOrDefault(currSum - targetSum, 0);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        count += solve2(root.left, targetSum, currSum);
        count += solve2(root.right, targetSum, currSum);
        prefix.put(currSum, prefix.get(currSum) - 1);
        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        prefix.put(0L, 1);
        return solve2(root, targetSum, 0);
    }
}