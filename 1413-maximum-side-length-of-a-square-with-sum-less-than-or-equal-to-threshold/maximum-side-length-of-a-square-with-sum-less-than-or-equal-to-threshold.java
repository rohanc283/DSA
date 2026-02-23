class Solution {
    public int findSum(int[][] mat, int r1, int c1, int k) {
        int r2 = r1 + k, c2 = c1 + k;
        int sum = mat[r2][c2];
        if (r1 > 0) {
            sum -= mat[r1 - 1][c2];
        }
        if (c1 > 0) {
            sum -= mat[r2][c1 - 1];
        }
        if (r1 > 0 && c1 > 0) {
            sum += mat[r1 - 1][c1 - 1];
        }
        return sum;
    }

    public boolean isPoss(int[][] mat, int threshold, int side) {
        int r = mat.length, c = mat[0].length;
        for (int i = 0; i + side - 1 < r; i++) {
            for (int j = 0; j + side - 1 < c; j++) {
                int sum = findSum(mat, i, j, side - 1);
                if (sum <= threshold) {
                    return true;

                }
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int r = mat.length, c = mat[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int top = i > 0 ? mat[i - 1][j] : 0;
                int left = j > 0 ? mat[i][j - 1] : 0;
                int diag = i > 0 && j > 0 ? mat[i - 1][j - 1] : 0;
                mat[i][j] += (top + left - diag);
            }
        }
        int best = 0;
        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         for (int k = best; k < Math.min(r - i, c - j); k++) {
        //             int sum = findSum(mat, i, j, k);
        //             if (sum <= threshold) {
        //                 best = Math.max(best, k + 1);
        //             } else {
        //                 break;
        //             }
        //         }
        //     }
        // }
        int l = 1, h = Math.min(r, c);
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(mat, threshold, m)) {
                best = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return best;
    }
}