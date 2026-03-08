class Solution {
    int M, N;
    Integer[][] dp;

    private int solve(int[][] grid, int r, int c) {
        if (r >= M || c >= N)
            return 0;
        if (dp[r][c] != null)
            return dp[r][c];
        int curr = grid[r][c];
        int up = r - 1 >= 0 && c + 1 < N && grid[r - 1][c + 1] > curr ? 1 + solve(grid, r - 1, c + 1) : 0;
        int right = c + 1 < N && grid[r][c + 1] > curr ? 1 + solve(grid, r, c + 1) : 0;
        int down = r + 1 < M && c + 1 < N && grid[r + 1][c + 1] > curr ? 1 + solve(grid, r + 1, c + 1) : 0;
        return dp[r][c] = Math.max(up, Math.max(right, down));
    }

    public int maxMoves(int[][] grid) {
        int ans = 0;
        M = grid.length;
        N = grid[0].length;
        dp = new Integer[M][N];
        for (int row = 0; row < M; row++) {
            ans = Math.max(ans, solve(grid, row, 0));
        }
        return ans;
    }
}