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

    Map<Integer, Integer> freq = new HashMap<>();

    Integer prev = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();

    public void traverse(TreeNode root) {
        if (root == null)
            return;

        freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
        traverse(root.left);
        traverse(root.right);
    }

    public int[] sol1(TreeNode root) {
        traverse(root);

        int maxFreq = 0;
        for (int count : freq.values()) {
            maxFreq = Math.max(maxFreq, count);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);
        if (prev == null || prev != root.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }
        prev = root.val;
        inorderTraversal(root.right);
    }

    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        return result.stream().mapToInt(i -> i).toArray();
    }
}