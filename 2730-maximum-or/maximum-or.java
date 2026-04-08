class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] prefixRight = new long[n];
        prefixRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefixRight[i] = nums[i] | prefixRight[i + 1];
        }
        long prefixLeft = 0L;
        long maxOr = 0L;
        for (int i = 0; i < n; i++) {
            long l = prefixLeft;
            long r = (i == n - 1) ? 0L : prefixRight[i + 1];
            long c = (nums[i] * 1L) << k;
            maxOr = Math.max(maxOr, l | r | c);
            prefixLeft |= nums[i];
        }
        return maxOr;
    }
}