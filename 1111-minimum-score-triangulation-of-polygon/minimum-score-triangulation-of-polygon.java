class Solution {
    Integer[][] dp;

    private int solve(int[] values, int i, int j) {
        if (i >= j || i == j - 1)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int curr = (values[i] * values[j] * values[k]) + solve(values, i, k) + solve(values, k, j);
            ans = Math.min(ans, curr);
        }
        return dp[i][j] = ans;
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new Integer[n][n];
        return solve(values, 0, n - 1);
    }
}