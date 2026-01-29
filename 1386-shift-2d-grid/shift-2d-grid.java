class Solution {
    private List<List<Integer>> toList(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            for (int val : row)
                listRow.add(val);
            res.add(listRow);
        }
        return res;
    }

    public List<List<Integer>> inPlace(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k = k % total;

        if (k == 0)
            return toList(grid);

        int[] temp = new int[k];
        for (int t = 0; t < k; t++) {
            int idx = total - k + t;
            temp[t] = grid[idx / n][idx % n];
        }

        for (int idx = total - k - 1; idx >= 0; idx--) {
            int newIdx = idx + k;
            grid[newIdx / n][newIdx % n] = grid[idx / n][idx % n];
        }

        for (int i = 0; i < k; i++) {
            grid[i / n][i % n] = temp[i];
        }

        return toList(grid);
    }

    public List<List<Integer>> withSpace(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k = k % total;

        if (k == 0)
            return toList(grid);
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = (i * n) + j;
                int newIdx = (idx + k) % total;
                res[newIdx / n][newIdx % n] = grid[i][j];
            }
        }
        return toList(res);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        return withSpace(grid, k);
    }
}