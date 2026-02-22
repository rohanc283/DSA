class Solution {
    public int maxElementRow(int[][] mat, int col) {
        int maxVal = Integer.MIN_VALUE, maxRow = -1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                maxRow = i;
            }
        }
        return maxRow;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat[0].length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int r = maxElementRow(mat, m);
            int left = m > 0 ? mat[r][m - 1] : -1;
            int right = m < n - 1 ? mat[r][m + 1] : -1;
            if (mat[r][m] > left && mat[r][m] > right)
                return new int[] { r, m };
            else if (mat[r][m] < left)
                h = m - 1;
            else
                l = m + 1;
        }
        return new int[] { -1, -1 };
    }
}