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
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public int minOperations(int[] nums) {
        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int operations = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums2[i])
                continue;
            int actualIdx = map.get(nums2[i]);
            swap(nums, i, actualIdx);
            map.put(nums[i], actualIdx);
            operations++;
        }
        return operations;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int operations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nums[i] = node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            operations += minOperations(nums);
        }
        return operations;
    }
}