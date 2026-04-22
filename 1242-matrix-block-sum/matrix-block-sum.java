class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i > 0 ? prefix[i - 1][j] : 0;
                int diag = i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0;
                int left = j > 0 ? prefix[i][j - 1] : 0;
                prefix[i][j] = mat[i][j] + (top + left - diag);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = i - k, r2 = i + k, c1 = j - k, c2 = j + k;
                // System.out.println(r1 + " " + c1 + " " + r2 + " " + c2);

                int p1 = prefix[Math.min(m - 1, r2)][Math.min(n - 1, c2)];
                int p2 = c1 <= 0 ? 0 : prefix[Math.min(m - 1, r2)][Math.max(0, c1 - 1)];

                int p3 = r1 <= 0 ? 0 : prefix[Math.max(0, r1 - 1)][Math.min(n - 1, c2)];
                int p4 = r1 <= 0 || c1 <= 0 ? 0 : prefix[Math.max(0, r1 - 1)][Math.max(0, c1 - 1)];
                // System.out.println(p1 + " " + p2 + " " + p3 + " " + p4);
                mat[i][j] = p1 - p2 - p3 + p4;

                // System.out.println(mat[i][j]);
                // System.out.println();

            }
            System.out.println();
        }
        return mat;

    }
}