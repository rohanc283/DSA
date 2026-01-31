class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
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
}