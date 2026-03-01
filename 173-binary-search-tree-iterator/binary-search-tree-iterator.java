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
class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode curr = null;

    private void populateNext() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
    }

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        curr = root;
        populateNext();
    }

    public int next() {
        if (curr == null)
            return -1;
        int val = curr.val;
        if (curr.right != null) {
            curr = curr.right;
            populateNext();
        } else {
            curr = stack.isEmpty() ? null : stack.pop();
        }
        return val;
    }

    public boolean hasNext() {
        if (curr == null && stack.isEmpty())
            return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */