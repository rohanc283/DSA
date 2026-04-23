class Solution {
    private int sol1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for (int r = 0; r < m; r++) {

            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 1 && r > 0) {
                    matrix[r][c] += matrix[r - 1][c];
                }
            }

            int[] temp = matrix[r].clone();
            Arrays.sort(temp);

            for (int i = n - 1; i >= 0; i--) {
                int height = temp[i];
                int width = n - i;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }

    public int largestSubmatrix(int[][] matrix) {
        return sol1(matrix);
    }
}