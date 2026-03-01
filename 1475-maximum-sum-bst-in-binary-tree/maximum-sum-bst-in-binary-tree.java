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
    class Info {
        public boolean isBst;
        public int low;
        public int high;
        public int sum;

        Info() {

        }

        Info(boolean isBst, int low, int high, int sum) {
            this.isBst = isBst;
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }

    int res = 0;

    private Info solve(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info left = solve(root.left);
        Info right = solve(root.right);
        Info curr = new Info();
        curr.sum = root.val + left.sum + right.sum;
        curr.low = Math.min(root.val, left.low);
        curr.high = Math.max(root.val, right.high);
        curr.isBst = left.isBst && right.isBst && (root.val > left.high && root.val < right.low);
        if (curr.isBst) {
            res = Math.max(res, curr.sum);
        }
        return curr;
    }

    public int maxSumBST(TreeNode root) {
        solve(root);
        return res;
    }
}