class Solution {
    public void sol1(int[][] matrix) {
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

    public void sol2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Check first row
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check first column
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Mark rows & cols
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Restore first row
        if (firstRowZero) {
            for (int c = 0; c < n; c++)
                matrix[0][c] = 0;
        }

        // Restore first column
        if (firstColZero) {
            for (int r = 0; r < m; r++)
                matrix[r][0] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        sol2(matrix);
    }
}