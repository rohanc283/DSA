class Solution {
    Integer[][] dp;
    int m, n;

    private int DFS(int i, int j, int[][] grid) {
        if (dp[i][j] != null)
            return dp[i][j];
        int res = 1;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dir) {
            int newRow = i + d[0];
            int newCol = j + d[1];
            if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n)
                continue;
            if (grid[newRow][newCol] < grid[i][j]) {
                res = Math.max(res, 1 + DFS(newRow, newCol, grid));
            }
        }
        return dp[i][j] = res;
    }

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new Integer[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, DFS(i, j, matrix));
            }
        }
        return res;
    }
}