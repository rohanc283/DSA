class Solution {
    public int largest(int[][] grid, int r, int c) {
        int maxi = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                maxi = Math.max(maxi, grid[i][j]);
            }
        }
        return maxi;
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int resN = n - 2;
        int[][] res = new int[resN][resN];
        for (int i = 0; i < resN; i++) {
            for (int j = 0; j < resN; j++) {
                res[i][j] = largest(grid, i, j);
            }
        }
        return res;
    }
}