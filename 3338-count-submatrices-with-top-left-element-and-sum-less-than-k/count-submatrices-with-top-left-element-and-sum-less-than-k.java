class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = i > 0 ? grid[i - 1][j] : 0;
                int r = j > 0 ? grid[i][j - 1] : 0;
                int d = i > 0 && j > 0 ? grid[i - 1][j - 1] : 0;
                grid[i][j] += ((t + r) - d);
                if (grid[i][j] <= k)
                    count++;
            }
        }
        return count;
    }
}