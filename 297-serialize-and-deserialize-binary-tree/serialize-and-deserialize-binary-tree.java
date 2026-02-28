/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null)
            return res.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                TreeNode front = queue.poll();
                if (front == null) {
                    res.append('N');
                } else {
                    res.append(front.val);
                    queue.offer(front.left);
                    queue.offer(front.right);
                }
                res.append(',');
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int n = data.length();
        if (n == 0)
            return null;
        String[] strList = data.split(",");
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(strList[0]));
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            i++;
            if (i < n && !strList[i].equals("N")) {
                front.left = new TreeNode(Integer.parseInt(strList[i]));
                queue.offer(front.left);
            }
            i++;
            if (i < n && !strList[i].equals("N")) {
                front.right = new TreeNode(Integer.parseInt(strList[i]));
                queue.offer(front.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));