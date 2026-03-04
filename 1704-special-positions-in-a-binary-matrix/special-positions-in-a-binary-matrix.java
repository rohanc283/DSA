class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowsCount = new int[m];
        int[] colsCount = new int[n];
        for (int i = 0; i < m; i++) {
            int zeros = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    zeros++;
            }
            rowsCount[i] = zeros;
        }
        for (int j = 0; j < n; j++) {
            int zeros = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == 0)
                    zeros++;
            }
            colsCount[j] = zeros;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowsCount[i] == n - 1 && colsCount[j] == m - 1) {
                    res++;
                }
            }
        }
        return res;
    }
}