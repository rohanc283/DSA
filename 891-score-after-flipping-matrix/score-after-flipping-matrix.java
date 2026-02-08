class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            int zeros = 0, ones = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0)
                    zeros++;
                else
                    ones++;
            }
            if (zeros > ones) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                curr = curr * 2 + grid[i][j];
            }
            res += curr;
        }
        return res;
    }
}