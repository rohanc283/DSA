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
        // First row impact check
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
            }
        }

        // First col impact check
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                firstColZero = true;
            }
        }

        // If any ele is 0 then mark that row[0] and col[0] as 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Populate 0 with help of row[0] and col[0]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Populate First row back
        for (int c = 0; c < n; c++) {
            if (firstRowZero)
                matrix[0][c] = 0;
        }

        // Populate First col back
        for (int r = 0; r < m; r++) {
            if (firstColZero) {
                matrix[r][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        sol2(matrix);
    }
}