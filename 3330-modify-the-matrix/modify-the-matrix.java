class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] temp = new int[n];
        for (int c = 0; c < n; c++) {
            int maxEle = matrix[0][c];
            for (int r = 1; r < m; r++) {
                maxEle = Math.max(maxEle, matrix[r][c]);
            }
            temp[c] = maxEle;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = temp[j];
                }
            }
        }
        return matrix;
    }
}