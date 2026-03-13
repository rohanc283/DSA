class Solution {
    Long[][] dp;

    private long solve(int[] nums, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return nums[i];
        if (dp[i][j] != null)
            return dp[i][j];
        long takeI = nums[i] + Math.min(solve(nums, i + 2, j), solve(nums, i + 1, j - 1));
        long takeJ = nums[j] + Math.min(solve(nums, i + 1, j - 1), solve(nums, i, j - 2));
        return dp[i][j] = Math.max(takeI, takeJ);
    }

    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int num : piles)
            sum += num;
        int n = piles.length;
        dp = new Long[n][n];
        long aliceScore = solve(piles, 0, n - 1);
        long bobScore = sum - aliceScore;
        return aliceScore >= bobScore;
    }
}