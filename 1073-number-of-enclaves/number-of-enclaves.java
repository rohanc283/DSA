class Solution {
    int m, n;
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void DFS(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        for (int[] d : dir) {
            int nr = i + d[0];
            int nc = j + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                DFS(grid, nr, nc);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                DFS(grid, 0, j);
            }

            if (grid[m - 1][j] == 1) {
                DFS(grid, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                DFS(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                DFS(grid, i, n - 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    ans++;
            }
        }
        return ans;
    }
}