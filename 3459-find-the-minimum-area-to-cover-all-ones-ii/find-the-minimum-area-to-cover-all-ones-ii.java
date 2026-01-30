class Solution {

    public int area(int[][] grid, int r1, int r2, int c1, int c2) {
        int sr = Integer.MAX_VALUE, er = -1;
        int sc = Integer.MAX_VALUE, ec = -1;

        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (grid[i][j] == 1) {
                    sr = Math.min(sr, i);
                    er = Math.max(er, i);
                    sc = Math.min(sc, j);
                    ec = Math.max(ec, j);
                }
            }
        }

        if (er == -1)
            return 0;
        return (er - sr + 1) * (ec - sc + 1);
    }

    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int a = area(grid, 0, i, 0, n);
                int b = area(grid, i, m, 0, j);
                int c = area(grid, i, m, j, n);
                res = Math.min(res, a + b + c);

                int d = area(grid, 0, i, 0, j);
                int e = area(grid, 0, i, j, n);
                int f = area(grid, i, m, 0, n);
                res = Math.min(res, d + e + f);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int a = area(grid, 0, i, 0, n);
                int b = area(grid, i, j, 0, n);
                int c = area(grid, j, m, 0, n);
                res = Math.min(res, a + b + c);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = area(grid, 0, m, 0, i);
                int b = area(grid, 0, m, i, j);
                int c = area(grid, 0, m, j, n);
                res = Math.min(res, a + b + c);
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                int a = area(grid, 0, m, 0, j);
                int b = area(grid, 0, i, j, n);
                int c = area(grid, i, m, j, n);
                res = Math.min(res, a + b + c);
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                int a = area(grid, 0, i, 0, j);
                int b = area(grid, i, m, 0, j);
                int c = area(grid, 0, m, j, n);
                res = Math.min(res, a + b + c);
            }
        }

        return res;
    }
}
