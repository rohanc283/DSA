class Solution {

    int M, N;
    int MOD = 1_000_000_007;
    Long[][][] dp;

    private long[] solve(int[][] grid, int i, int j) {

        if (i == M - 1 && j == N - 1) {
            return new long[] { grid[i][j], grid[i][j] };
        }

        if (dp[i][j][0] != null) {
            return new long[] { dp[i][j][0], dp[i][j][1] };
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if (j + 1 < N) {
            long[] right = solve(grid, i, j + 1);

            long a = grid[i][j] * right[0];
            long b = grid[i][j] * right[1];

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        if (i + 1 < M) {
            long[] down = solve(grid, i + 1, j);

            long a = grid[i][j] * down[0];
            long b = grid[i][j] * down[1];

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        dp[i][j][0] = maxVal;
        dp[i][j][1] = minVal;

        return new long[] { maxVal, minVal };
    }

    public int maxProductPath(int[][] grid) {

        M = grid.length;
        N = grid[0].length;

        dp = new Long[M][N][2];

        long[] ans = solve(grid, 0, 0);

        if (ans[0] < 0)
            return -1;

        return (int) (ans[0] % MOD);
    }
}