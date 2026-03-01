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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (true) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            TreeNode n1 = null, n2 = null;
            if (!stack1.isEmpty()) {
                n1 = stack1.peek();
                stack1.pop();
            }
            if (!stack2.isEmpty()) {
                n2 = stack2.peek();
                stack2.pop();
            }
            if (n1 == null && n2 == null)
                break;
            if (n1 == null && n2 != null) {
                res.add(n2.val);
                root2 = n2.right;
            } else if (n1 != null && n2 == null) {
                res.add(n1.val);
                root1 = n1.right;
            } else if (n1.val < n2.val) {
                res.add(n1.val);
                stack2.push(n2);
                root1 = n1.right;
            } else {
                res.add(n2.val);
                stack1.push(n1);
                root2 = n2.right;
            }
        }
        return res;
    }
}