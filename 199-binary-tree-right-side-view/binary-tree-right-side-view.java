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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            res.add(-1);
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                TreeNode front = queue.poll();
                res.set(res.size() - 1, front.val);
                if (front.left != null)
                    queue.offer(front.left);
                if (front.right != null)
                    queue.offer(front.right);
            }
        }
        return res;
    }
}