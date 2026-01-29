class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k = k % n;
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    int newIdx = (j - k + n) % n;
                    if (mat[i][newIdx] != mat[i][j])
                        return false;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    int newIdx = (j + k) % n;
                    if (mat[i][newIdx] != mat[i][j])
                        return false;
                }
            }
        }
        return true;
    }
}