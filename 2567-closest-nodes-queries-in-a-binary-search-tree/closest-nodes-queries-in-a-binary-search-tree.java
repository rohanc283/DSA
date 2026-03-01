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

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);

        List<List<Integer>> ans = new ArrayList<>();

        for (int q : queries) {

            int idx = Collections.binarySearch(sorted, q);

            int mini = -1;
            int maxi = -1;

            if (idx >= 0) {
                mini = sorted.get(idx);
                maxi = sorted.get(idx);
            } else {
                int insertPos = -idx - 1;

                // floor
                if (insertPos - 1 >= 0)
                    mini = sorted.get(insertPos - 1);

                // ceil
                if (insertPos < sorted.size())
                    maxi = sorted.get(insertPos);
            }

            ans.add(Arrays.asList(mini, maxi));
        }

        return ans;
    }
}