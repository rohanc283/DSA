class Solution {
    public int minimumArea(int[][] grid, int r1, int c1, int r2, int c2) {
        int sr = Integer.MAX_VALUE, sc = Integer.MAX_VALUE, er = -1, ec = -1;
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (grid[i][j] == 1) {
                    sr = Math.min(sr, i);
                    sc = Math.min(sc, j);

                    er = Math.max(er, i);
                    ec = Math.max(ec, j);
                }
            }
        }
        return sr == Integer.MAX_VALUE && sc == Integer.MAX_VALUE ? 0 : (er - sr + 1) * (ec - sc + 1);
    }

    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = m * n;
        for (int rowSplit = 1; rowSplit < m; rowSplit++) {
            for (int colSplit = 1; colSplit < n; colSplit++) {
                int top = minimumArea(grid, 0, 0, rowSplit, n);
                int left = minimumArea(grid, rowSplit, 0, m, colSplit);
                int right = minimumArea(grid, rowSplit, colSplit, m, n);
                res = Math.min(res, top + left + right);

                left = minimumArea(grid, 0, 0, rowSplit, colSplit);
                right = minimumArea(grid, 0, colSplit, rowSplit, n);
                int bottom = minimumArea(grid, rowSplit, 0, m, n);
                res = Math.min(res, left + right + bottom);
            }
        }
        for (int colSplit = 1; colSplit < n; colSplit++) {
            for (int rowSplit = 1; rowSplit < m; rowSplit++) {
                int top = minimumArea(grid, 0, 0, rowSplit, colSplit);
                int bottom = minimumArea(grid, rowSplit, 0, m, colSplit);
                int right = minimumArea(grid, 0, colSplit, m, n);
                res = Math.min(res, top + bottom + right);

                int left = minimumArea(grid, 0, 0, m, colSplit);
                top = minimumArea(grid, 0, colSplit, rowSplit, n);
                bottom = minimumArea(grid, rowSplit, colSplit, m, n);
                res = Math.min(res, left + top + bottom);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int top = minimumArea(grid, 0, 0, i, n);
                int middle = minimumArea(grid, i, 0, j, n);
                int bottom = minimumArea(grid, j, 0, m, n);
                res = Math.min(res, top + middle + bottom);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = minimumArea(grid, 0, 0, m, i);
                int middle = minimumArea(grid, 0, i, m, j);
                int right = minimumArea(grid, 0, j, m, n);
                res = Math.min(res, left + middle + right);
            }
        }
        return res;
    }
}