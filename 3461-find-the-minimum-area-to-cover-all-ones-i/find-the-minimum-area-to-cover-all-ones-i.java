class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sr = m, sc = n, er = -1, ec = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sr = Math.min(sr, i);
                    sc = Math.min(sc, j);

                    er = Math.max(er, i);
                    ec = Math.max(ec, j);
                }
            }
        }
        return sr == m && sc == n ? 0 : (er - sr + 1) * (ec - sc + 1);
    }
}