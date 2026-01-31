class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int oneCount = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    oneCount++;
            }
            if (res[1] < oneCount) {
                res[1] = oneCount;
                res[0] = i;
            }
        }
        return res;
    }
}