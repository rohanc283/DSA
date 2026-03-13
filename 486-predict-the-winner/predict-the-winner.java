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
        return Math.max(takeI, takeJ);
    }

    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int n = nums.length;
        dp = new Long[n][n];
        long player1Score = solve(nums, 0, n - 1);
        long player2Score = sum - player1Score;
        return player1Score >= player2Score;
    }
}