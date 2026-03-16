class Solution {
    int m, n;
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private boolean DFS(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if (grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        boolean left = DFS(grid, i, j - 1);
        boolean right = DFS(grid, i, j + 1);

        boolean up = DFS(grid, i - 1, j);
        boolean down = DFS(grid, i + 1, j);
        return up && down && left && right;
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (DFS(grid, i, j))
                        count++;
                }
            }
        }
        return count;
    }
}