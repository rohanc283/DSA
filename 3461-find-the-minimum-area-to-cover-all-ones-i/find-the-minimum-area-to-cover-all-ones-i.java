class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sr = m - 1, er = 0;
        int sc = n - 1, ec = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sr = Math.min(sr, i);
                    er = Math.max(er, i);
                    sc = Math.min(sc, j);
                    ec = Math.max(ec, j);
                }
            }
        }
        return (er - sr + 1) * (ec - sc + 1);
    }
}