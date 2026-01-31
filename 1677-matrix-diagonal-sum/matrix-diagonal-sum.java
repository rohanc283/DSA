class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            sum += mat[i][j];
        }
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (i == j)
                continue;
            sum += mat[i][j];
        }
        return sum;
    }
}