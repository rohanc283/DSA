class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k = k % n;
        int[][] shiftedMat = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    int newIdx = (j - k + n) % n;
                    System.out.println(newIdx + " " + j + " " + k);
                    shiftedMat[i][newIdx] = mat[i][j];
                }
            } else {
                for (int j = 0; j < n; j++) {
                    int newIdx = (j + k) % n;
                    shiftedMat[i][newIdx] = mat[i][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != shiftedMat[i][j])
                    return false;
            }
        }
        return true;
    }
}