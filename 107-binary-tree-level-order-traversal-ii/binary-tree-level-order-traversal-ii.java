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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                TreeNode front = queue.poll();
                curr.add(front.val);
                if (front.left != null)
                    queue.offer(front.left);
                if (front.right != null)
                    queue.offer(front.right);
            }
            res.add(curr);
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = levelOrder(root);
        Collections.reverse(res);
        return res;
    }
}