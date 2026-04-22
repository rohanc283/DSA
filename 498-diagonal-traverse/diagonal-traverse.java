class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int t = m * n;
        int[] res = new int[t];
        int r = 0, c = 0;
        int resIdx = 0;
        while (resIdx < t) {
            int i = r, j = c;
            while (i >= 0 && j < n && resIdx < t) {
                res[resIdx++] = mat[i][j];
                i--;
                j++;
            }
            i++;
            if (j >= n) {
                j = n - 1;
                i++;
            }

            while (i < m && j >= 0 && resIdx < t) {
                res[resIdx++] = mat[i][j];
                i++;
                j--;
            }

            j++;
            if (i >= m) {
                i = m - 1;
                j++;
            }

            r = i;
            c = j;
        }
        return res;
    }
}