class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] sum = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[j] = matrix[i][j] == 0 ? 0 : sum[j] + matrix[i][j];
            }
            int[] temp = Arrays.copyOf(sum, n);
            Arrays.sort(temp);
            int mini = Integer.MAX_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                if (temp[j] == 0)
                    break;
                mini = Math.min(mini, temp[j]);
                res = Math.max(res, mini * ((n - j - 1) + 1));
            }
        }
        return res;
    }
}