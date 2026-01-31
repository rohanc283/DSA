class Solution {
    public int hourglassSum(int[][] grid, int r, int c) {
        int sum = 0;
        for (int j = c; j < c + 3; j++) {
            sum += grid[r][j];
            sum += grid[r + 2][j];
        }
        sum += grid[r + 1][c + 1];
        return sum;
    }

    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxi = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxi = Math.max(maxi, hourglassSum(grid, i, j));
            }
        }
        return maxi;
    }
}