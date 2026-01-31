class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for (int c = 0; c < n; c++) {
            int j = c, i = 0;
            while (i < m && j >= 0 && j < n) {
                if (j == n - 1 && grid[i][j] == 1) {
                    j = -1;
                    break;
                } else if (j == 0 && grid[i][j] == -1) {
                    j = -1;
                    break;
                } else if (grid[i][j] == 1 && j + 1 < n && grid[i][j + 1] == -1) {
                    j = -1;
                    break;
                } else if (grid[i][j] == -1 && j - 1 >= 0 && grid[i][j - 1] == 1) {
                    j = -1;
                    break;
                } else {
                    j += grid[i][j];
                    i++;
                }
            }
            res[c] = j;
        }
        return res;
    }
}