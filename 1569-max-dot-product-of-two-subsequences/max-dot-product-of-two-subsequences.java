class Solution {
    int M, N;
    Integer[][] dp;

    private int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i >= M || j >= N)
            return Integer.MIN_VALUE;
        if (dp[i][j] != null)
            return dp[i][j];
        int currProduct = nums1[i] * nums2[j];
        int takeIJ = currProduct + Math.max(0, solve(nums1, nums2, i + 1, j + 1));
        int takeI = solve(nums1, nums2, i + 1, j);
        int takeJ = solve(nums1, nums2, i, j + 1);
        return dp[i][j] = Math.max(currProduct, Math.max(takeIJ, Math.max(takeI, takeJ)));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        M = nums1.length;
        N = nums2.length;
        dp = new Integer[M][N];
        return solve(nums1, nums2, 0, 0);
    }
}