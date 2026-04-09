class Solution {
    private void toggleRow(int[][] grid, int r) {
        for (int c = 0; c < grid[0].length; c++) {
            grid[r][c] ^= 1;
        }
    }

    private void toggleCol(int[][] grid, int c) {
        for (int r = 0; r < grid.length; r++) {
            grid[r][c] ^= 1;
        }
    }

    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                toggleRow(grid, i);
            }
        }
        for (int c = 1; c < m; c++) {
            int one = 0, zero = 0;
            for (int r = 0; r < n; r++) {
                if (grid[r][c] == 0)
                    zero++;
                else
                    one++;
            }
            if (zero > one) {
                toggleCol(grid, c);
            }
        }
        int sum = 0;
        for (int r = 0; r < n; r++) {
            int curr = 0;
            for (int c = 0; c < m; c++) {
                curr = curr * 2 + grid[r][c];
            }
            sum += curr;
        }
        return sum;
    }
}