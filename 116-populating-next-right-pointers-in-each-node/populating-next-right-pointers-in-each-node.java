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
    public Node sol1(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                Node front = queue.poll();
                if (i != s - 1) {
                    front.next = queue.peek();
                }
                if (front.left != null)
                    queue.offer(front.left);
                if (front.right != null)
                    queue.offer(front.right);
            }
        }
        return root;
    }

    public Node sol2(Node root) {
        if (root == null)
            return root;
        Node leftMost = root;
        while (leftMost.left != null) {
            Node curr = leftMost;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public Node connect(Node root) {
        return sol2(root);
    }
}