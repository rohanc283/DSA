class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0, mini = Integer.MAX_VALUE, negCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cellValue = matrix[i][j];
                sum += Math.abs(cellValue);
                if (cellValue < 0) {
                    negCount++;
                }
                mini = Math.min(mini, Math.abs(cellValue));
            }
        }
        if (negCount % 2 != 0) {
            sum -= (2 * mini);
        }
        return sum;
    }
}