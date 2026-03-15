class Solution {

    boolean[][] visited;
    int m, n;

    private boolean dfs(char[][] grid, int r, int c, int pr, int pc) {
        visited[r][c] = true;

        int[][] dirs = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;

            if (grid[nr][nc] != grid[r][c])
                continue;

            if (!visited[nr][nc]) {
                boolean hasCycle = dfs(grid, nr, nc, r, c);
                if (hasCycle)
                    return true;
            } else {
                if (nr != pr || nc != pc)
                    return true;
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    boolean hasCycle = dfs(grid, i, j, -1, -1);
                    if (hasCycle)
                        return true;
                }
            }
        }
        return false;
    }
}