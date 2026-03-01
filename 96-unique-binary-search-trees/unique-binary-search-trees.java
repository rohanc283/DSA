class Solution {
    int[][] dp;

    private int solve(int s, int n) {
        if (n <= 1)
            return 1;
        if (s > n)
            return 1;
        if (dp[s][n] != -1)
            return dp[s][n];
        int res = 0;
        for (int i = s; i <= n; i++) {
            int left = solve(s, i - 1);
            int right = solve(i + 1, n);
            res += (left * right);
        }
        return dp[s][n] = res;
    }

    public int numTrees(int n) {
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(1, n);
    }
}