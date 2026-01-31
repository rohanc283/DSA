class Solution {
    public int[][] withSpace(int[][] grid, int m, int n) {
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

    public int[][] inPlace(int[][] grid, int m, int n) {
        int firstColOneCount = 0;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1)
                firstColOneCount++;
        }

        for (int i = 0; i < m; i++) {
            int oneCount = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    oneCount++;
            }
            grid[i][0] = oneCount;
        }

        for (int j = 1; j < n; j++) {
            int oneCount = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1)
                    oneCount++;
            }
            grid[0][j] = oneCount;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][0] + grid[0][j] - (n - grid[i][0]) - (m - grid[0][j]);
            }
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][0] + grid[0][j] - (n - grid[0][0]) - (m - grid[0][j]);
        }

        for (int i = 0; i < m; i++) {
            grid[i][0] = grid[i][0] + firstColOneCount - (n - grid[i][0]) - (m - firstColOneCount);
        }
        return grid;
    }

    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return inPlace(grid, m, n);
    }
}