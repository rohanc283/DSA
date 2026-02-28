/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int res = 0;

    private void solve(Node root, int depth) {
        if (root == null)
            return;
        res = Math.max(res, depth + 1);
        for (int i = 0; i < root.children.size(); i++) {
            solve(root.children.get(i), depth + 1);
        }
    }

    public int maxDepth(Node root) {
        solve(root, 0);
        return res;
    }
}