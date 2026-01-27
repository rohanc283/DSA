class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        int[] diff = new int[n];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            diff[l] += 1;
            if (r + 1 < n) {
                diff[r + 1] -= 1;
            }
        }

        for (int j = 1; j < n; j++) {
            diff[j] += diff[j - 1];
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] - diff[j] > 0) {
                return false;
            }
        }
        return true;
    }
}