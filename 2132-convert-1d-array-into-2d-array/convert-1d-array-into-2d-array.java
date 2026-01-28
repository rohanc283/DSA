class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int total = m * n;
        if (original.length != total)
            return new int[0][0];

        int[][] res = new int[m][n];
        int r = 0, c = 0;
        for (int i = 0; i < original.length; i++) {
            if (c >= n) {
                c = 0;
                r++;
            }
            res[r][c] = original[i];
            c++;
        }
        return res;
    }
}