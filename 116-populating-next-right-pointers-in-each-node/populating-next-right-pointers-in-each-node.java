/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            List<Node> curr = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                Node front = queue.poll();
                curr.add(front);
                if (front.left != null)
                    queue.offer(front.left);
                if (front.right != null)
                    queue.offer(front.right);
            }
            for (int i = 0; i < s - 1; i++) {
                curr.get(i).next = curr.get(i + 1);
            }
        }
        return root;
    }
}