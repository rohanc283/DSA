class Solution {
    Long[][] dp;

    private long solve(int[] nums, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return nums[i];
        if (dp[i][j] != null)
            return dp[i][j];
        long takeI = nums[i] - solve(nums, i + 1, j);
        long takeJ = nums[j] - solve(nums, i, j - 1);
        return dp[i][j] = Math.max(takeI, takeJ);
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Long[n][n];
        return solve(piles, 0, n - 1) >= 0;
    }
}