class Solution {
    int N;
    int[][][] dp;

    private int solve(int[][] grid, int r1, int c1, int r2) {

        int c2 = r1 + c1 - r2;

        if (r1 >= N || c1 >= N || r2 >= N || c2 >= N)
            return Integer.MIN_VALUE;

        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == N - 1 && c1 == N - 1)
            return grid[r1][c1];

        if (dp[r1][c1][r2] != Integer.MIN_VALUE)
            return dp[r1][c1][r2];

        int cherries = grid[r1][c1];

        if (r1 != r2)
            cherries += grid[r2][c2];

        int best = Math.max(
                Math.max(
                        solve(grid, r1 + 1, c1, r2 + 1),
                        solve(grid, r1, c1 + 1, r2)),
                Math.max(
                        solve(grid, r1 + 1, c1, r2),
                        solve(grid, r1, c1 + 1, r2 + 1)));

        cherries += best;

        return dp[r1][c1][r2] = cherries;
    }

    public int cherryPickup(int[][] grid) {
        N = grid.length;
        dp = new int[N][N][N];

        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);

        return Math.max(0, solve(grid, 0, 0, 0));
    }
}