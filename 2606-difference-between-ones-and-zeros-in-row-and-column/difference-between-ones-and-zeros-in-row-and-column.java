class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowCounts = new int[m][2];
        int[][] colCounts = new int[n][2];

        for (int i = 0; i < m; i++) {
            int oneCount = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    oneCount++;
            }
            rowCounts[i][0] = n - oneCount;
            rowCounts[i][1] = oneCount;
        }

        for (int j = 0; j < n; j++) {
            int oneCount = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1)
                    oneCount++;
            }
            colCounts[j][0] = m - oneCount;
            colCounts[j][1] = oneCount;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = rowCounts[i][1] + colCounts[j][1] - rowCounts[i][0] - colCounts[j][0];
            }
        }
        return grid;
    }
}