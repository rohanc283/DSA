class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < queries.length; i++) {
            int row1 = queries[i][0];
            int col1 = queries[i][1];
            int row2 = queries[i][2];
            int col2 = queries[i][3];

            for (int r = row1; r <= row2; r++) {
                mat[r][col1] += 1;
                if (col2 + 1 < n) {
                    mat[r][col2 + 1] -= 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }
        return mat;
    }
}