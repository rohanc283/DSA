class Solution {
    Integer[][] dp;

    private int solve(int i, int j) {
        if (i >= j)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            ans = Math.min(ans, k + Math.max(solve(i, k - 1), solve(k + 1, j)));
        }
        return dp[i][j] = ans;
    }

    public int getMoneyAmount(int n) {
        dp = new Integer[n + 1][n + 1];
        return solve(1, n);
    }
}