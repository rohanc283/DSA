class Solution {
    int M, N;
    Integer[][] dp;

    private int solve(int[][] grid, int r, int prev) {
        if (r >= M)
            return 0;
        if (dp[r][prev + 1] != null)
            return dp[r][prev + 1];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            if (j == prev)
                continue;
            int curr = grid[r][j] + solve(grid, r + 1, j);
            ans = Math.min(ans, curr);
        }
        return dp[r][prev + 1] = ans;
    }

    public int minFallingPathSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        dp = new Integer[M][N + 2];
        return solve(grid, 0, -1);
    }
}