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
}
*/

class Solution {
    List<Integer> res = new ArrayList<>();

    private void solve(Node root) {
        if (root == null)
            return;
        for (int i = 0; i < root.children.size(); i++) {
            solve(root.children.get(i));
        }
        res.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        solve(root);
        return res;
    }
}