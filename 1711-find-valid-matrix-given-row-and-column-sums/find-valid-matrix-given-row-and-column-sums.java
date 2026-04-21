class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], 0);
        }
        int i = 0, j = 0;
        while (i < m && j < n) {
            int s = rowSum[i] <= colSum[j] ? rowSum[i] : colSum[j];
            res[i][j] = s;
            rowSum[i] -= s;
            colSum[j] -= s;
            if (rowSum[i] <= 0)
                i++;
            if (colSum[j] <= 0)
                j++;
        }
        return res;
    }
}