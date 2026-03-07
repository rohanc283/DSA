class Solution {
    int[][] adj = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 1, 0, 7 }, { 2, 6 }, { 1, 3 },
            { 2, 4 } };
    int MOD = 1_000_000_007;
    Integer[][] dp;

    public int solve(int i, int n) {
        if (n == 0)
            return 1;
        if (dp[i][n] != null)
            return dp[i][n];
        int ans = 0;
        for (int neigh : adj[i]) {
            ans = (ans + solve(neigh, n - 1)) % MOD;
        }
        return dp[i][n] = ans;
    }

    public int knightDialer(int n) {
        dp = new Integer[10][n];
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans = (ans + solve(i, n - 1)) % MOD;
        }
        return ans;
    }
}