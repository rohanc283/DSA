class Solution {
    private int[][] getLeftToRightDiagSum(int[][] grid, int m, int n) {
        int[][] sum = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                sum[r][c] = grid[r][c] + (r > 0 && c > 0 ? sum[r - 1][c - 1] : 0);
            }
        }
        return sum;
    }

    private int[][] getRightToLeftDiagSum(int[][] grid, int m, int n) {
        int[][] sum = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = n - 1; c >= 0; c--) {
                sum[r][c] = grid[r][c] + (r > 0 && c < n - 1 ? sum[r - 1][c + 1] : 0);
            }
        }
        return sum;
    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] leftToRightDiagSum = getLeftToRightDiagSum(grid, m, n);
        int[][] rightToLeftDiagSum = getRightToLeftDiagSum(grid, m, n);

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                for (int size = 1; i + (2 * size) < m && j - size >= 0 && j + size < n; size++) {
                    int a = leftToRightDiagSum[i + size][j + size]
                            - (i > 0 && j > 0 ? leftToRightDiagSum[i - 1][j - 1] : 0);
                    int b = rightToLeftDiagSum[i + (2 * size)][j] - rightToLeftDiagSum[i + size][j + size];
                    int c = leftToRightDiagSum[i + (2 * size) - 1][j - 1]
                            - (j - size > 0 ? leftToRightDiagSum[i + size - 1][j - size - 1] : 0);
                    int d = rightToLeftDiagSum[i + size - 1][j - size + 1] - rightToLeftDiagSum[i][j];
                    int sum = a + b + c + d;
                    set.add(sum);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!set.isEmpty()) {
            res.add(set.last());
            set.remove(set.last());
            if (res.size() == 3)
                break;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}