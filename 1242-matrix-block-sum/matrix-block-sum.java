class Solution {
    public int[][] solUsingRowPrefix(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            prefix[i][0] = mat[i][0];
            for (int j = 1; j < n; j++) {
                prefix[i][j] = mat[i][j] + prefix[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int r = i - k; r <= i + k; r++) {
                    if (r < 0 || r >= m)
                        continue;
                    int rightVal = j + k >= n ? prefix[r][n - 1] : prefix[r][j + k];
                    int leftVal = j - k - 1 < 0 ? 0 : prefix[r][j - k - 1];
                    sum += (rightVal - leftVal);
                }
                mat[i][j] = sum;
            }
        }
        return mat;
    }

    public int[][] solUsingMatrixPrefix(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        // Build 2D prefix sum
        int[][] prefix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i > 0 ? prefix[i - 1][j] : 0;
                int left = j > 0 ? prefix[i][j - 1] : 0;
                int diag = (i > 0 && j > 0) ? prefix[i - 1][j - 1] : 0;
                prefix[i][j] = mat[i][j] + top + left - diag;
            }
        }

        // Compute block sums
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                int total = prefix[r2][c2];
                int top = r1 > 0 ? prefix[r1 - 1][c2] : 0;
                int left = c1 > 0 ? prefix[r2][c1 - 1] : 0;
                int diag = (r1 > 0 && c1 > 0) ? prefix[r1 - 1][c1 - 1] : 0;

                res[i][j] = total - top - left + diag;
            }
        }

        return res;
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        return solUsingMatrixPrefix(mat, k);
    }
}