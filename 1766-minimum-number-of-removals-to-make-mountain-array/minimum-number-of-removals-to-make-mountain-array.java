class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dpLeftToRight = new int[n];
        int[] dpRightToLeft = new int[n];
        Arrays.fill(dpLeftToRight, 1);
        Arrays.fill(dpRightToLeft, 1);
        for (int i = 1; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    curr = Math.max(curr, dpLeftToRight[j]);
                }
            }
            dpLeftToRight[i] += curr;
        }
        for (int i = n - 2; i >= 0; i--) {
            int curr = 0;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    curr = Math.max(curr, dpRightToLeft[j]);
                }
            }
            dpRightToLeft[i] += curr;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dpLeftToRight[i] > 1 && dpRightToLeft[i] > 1) {
                int elements = dpLeftToRight[i] + dpRightToLeft[i] - 1;
                res = Math.min(res, n - elements);
            }
        }
        return res;
    }
}