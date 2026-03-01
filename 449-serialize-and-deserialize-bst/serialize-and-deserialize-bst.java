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

    private void serializeHelper(TreeNode root, StringBuilder res) {
        if (root == null)
            return;
        res.append(root.val);
        if (root.left != null) {
            res.append(',');
            serializeHelper(root.left, res);
        }

        if (root.right != null) {
            res.append(',');
            serializeHelper(root.right, res);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serializeHelper(root, res);
        return res.toString();
    }

    private TreeNode deSerializeHelper(String[] nodes, int[] idx, int maxi) {
        if (idx[0] >= nodes.length)
            return null;
        int val = Integer.parseInt(nodes[idx[0]]);
        if (val > maxi)
            return null;
        TreeNode root = new TreeNode(val);
        idx[0]++;
        root.left = deSerializeHelper(nodes, idx, val);
        root.right = deSerializeHelper(nodes, idx, maxi);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        int[] idx = new int[1];
        String[] nodes = data.split(",");
        int n = nodes.length;
        return deSerializeHelper(nodes, idx, Integer.MAX_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;