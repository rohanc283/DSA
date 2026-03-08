class Solution {
    int M, N;
    int MOD = 1_000_000_007;
    Integer[][][] dp;

    private int solve(int r, int c, int maxMove) {
        if (r < 0 || r >= M || c < 0 || c >= N)
            return 1;

        if (maxMove <= 0)
            return 0;
        if (dp[r][c][maxMove] != null)
            return dp[r][c][maxMove];
        int[][] directions = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        int ans = 0;
        for (int[] dir : directions) {
            int i = r + dir[0];
            int j = c + dir[1];
            ans = (ans + solve(i, j, maxMove - 1)) % MOD;
        }
        return dp[r][c][maxMove] = ans;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        M = m;
        N = n;
        dp = new Integer[M][N][maxMove + 1];
        return solve(startRow, startColumn, maxMove);
    }
}