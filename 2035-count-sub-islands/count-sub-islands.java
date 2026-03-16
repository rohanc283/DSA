class Solution {

    int m, n;

    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return true;

        if (visited[r][c] || grid2[r][c] == 0)
            return true;

        visited[r][c] = true;

        boolean isSub = true;

        if (grid1[r][c] == 0)
            isSub = false;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (!dfs(grid1, grid2, nr, nc, visited))
                isSub = false;
        }

        return isSub;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j, visited))
                        ans++;
                }
            }
        }
        return ans;
    }
}