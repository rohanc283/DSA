/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class NodeWithDistance {
        public int distance;
        public TreeNode node;

        NodeWithDistance(int distance, TreeNode node) {
            this.distance = distance;
            this.node = node;
        }
    }

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    Set<TreeNode> visitedNodes = new HashSet<>();

    private void fillParentNodes(TreeNode root, TreeNode parent) {
        if (root == null)
            return;
        parentMap.put(root, parent);
        fillParentNodes(root.left, root);
        fillParentNodes(root.right, root);
    }

    private List<Integer> sol1(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || target == null)
            return res;
        fillParentNodes(root, null);
        Queue<NodeWithDistance> queue = new ArrayDeque<>();
        queue.offer(new NodeWithDistance(0, target));
        visitedNodes.add(target);
        while (!queue.isEmpty()) {
            NodeWithDistance front = queue.poll();
            int currDistance = front.distance;
            TreeNode currNode = front.node;
            if (currDistance == k) {
                res.add(currNode.val);
                continue;
            }
            if (currDistance > k)
                continue;
            TreeNode parent = parentMap.get(currNode);
            TreeNode leftChild = currNode.left;
            TreeNode rightChild = currNode.right;

            if (parent != null && !visitedNodes.contains(parent)) {
                queue.offer(new NodeWithDistance(currDistance + 1, parent));
                visitedNodes.add(parent);
            }

            if (leftChild != null && !visitedNodes.contains(leftChild)) {
                queue.offer(new NodeWithDistance(currDistance + 1, leftChild));
                visitedNodes.add(leftChild);
            }

            if (rightChild != null && !visitedNodes.contains(rightChild)) {
                queue.offer(new NodeWithDistance(currDistance + 1, rightChild));
                visitedNodes.add(rightChild);
            }
        }
        return res;
    }

    private List<Integer> sol2(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || target == null)
            return res;
        fillParentNodes(root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        visitedNodes.add(target);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                for (TreeNode node : queue) {
                    res.add(node.val);
                }
                break;
            }

            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                TreeNode parent = parentMap.get(front);
                TreeNode leftChild = front.left;
                TreeNode rightChild = front.right;

                if (parent != null && !visitedNodes.contains(parent)) {
                    queue.offer(parent);
                    visitedNodes.add(parent);
                }

                if (leftChild != null && !visitedNodes.contains(leftChild)) {
                    queue.offer(leftChild);
                    visitedNodes.add(leftChild);
                }

                if (rightChild != null && !visitedNodes.contains(rightChild)) {
                    queue.offer(rightChild);
                    visitedNodes.add(rightChild);
                }
            }

            distance++;
        }
        return res;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        return sol2(root, target, k);
    }
}