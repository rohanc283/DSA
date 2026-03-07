class Solution {
    int[][] dp;

    // private int solve(int n, int k) {
    //     if (n == 0)
    //         return 0;
    //     if (k == 0)
    //         return 1;
    //     if (dp[n][k] != null)
    //         return dp[n][k];
    //     int ans = 0;
    //     for (int inv = 0; inv <= Math.min(n - 1, k); inv++) {
    //         ans = (ans + solve(n - 1, k - inv)) % 1_000_000_007;
    //     }
    //     return dp[n][k] = ans;
    // }

    public int solveTab(int n, int K) {
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int k = 1; k <= K; k++) {
                int ans = 0;
                for (int inv = 0; inv <= Math.min(i - 1, k); inv++) {
                    ans = (ans + dp[i - 1][k - inv]) % 1_000_000_007;
                }
                dp[i][k] = ans;
            }
        }
        return dp[n][K];
    }

    public int kInversePairs(int n, int k) {
        dp = new int[n + 1][k + 1];
        return solveTab(n, k);
    }
}