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
    public void preorder(TreeNode root, List<Integer> rootLeafNodeValues) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            rootLeafNodeValues.add(root.val);
            return;
        }
        preorder(root.left, rootLeafNodeValues);
        preorder(root.right, rootLeafNodeValues);
    }

    public boolean sol1(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        preorder(root1, l1);
        preorder(root2, l2);
        return l1.equals(l2);
    }

    private Integer getNextLeaf(Stack<TreeNode> stack) {
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);

            if (node.left == null && node.right == null) {
                return node.val;
            }
        }
        return null;
    }

    public boolean sol2(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (root1 != null)
            stack1.push(root1);
        if (root2 != null)
            stack2.push(root2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            Integer leaf1 = getNextLeaf(stack1);
            Integer leaf2 = getNextLeaf(stack2);

            if (!leaf1.equals(leaf2)) {
                return false;
            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return sol2(root1, root2);
    }
}