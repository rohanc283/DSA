class Solution {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> zeros = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }

        for (int i = 0; i < zeros.size(); i++) {
            int r = zeros.get(i).get(0);
            int c = zeros.get(i).get(1);
            for (int j = 0; j < n; j++) {
                matrix[r][j] = 0;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][c] = 0;
            }
        }
    }
}