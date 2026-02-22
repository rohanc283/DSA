class Solution {
    public int calculateThreshold(int[] nums, int divisor) {
        int n = nums.length;
        int threshold = 0;
        for (int i = 0; i < n; i++) {
            int currThreshold = (nums[i] + divisor - 1) / divisor;
            threshold += currThreshold;
        }
        return threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        int res = 0;
        while (low <= high) {
            int m = low + (high - low) / 2;
            int currThreshold = calculateThreshold(nums, m);
            if (currThreshold <= threshold) {
                res = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return res;
    }
}