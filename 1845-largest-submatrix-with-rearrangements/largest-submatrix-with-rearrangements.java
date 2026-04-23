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

    private int sol2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        List<int[]> prev = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            List<int[]> curr = new ArrayList<>();
            boolean[] seen = new boolean[n];
            for (int[] p : prev) {
                int col = p[0];
                int height = p[1];
                if (matrix[r][col] == 1) {
                    curr.add(new int[] { col, height + 1 });
                    seen[col] = true;
                }
            }

            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 1 && seen[c] == false) {
                    curr.add(new int[] { c, 1 });
                }
            }

            for (int i = 0; i < curr.size(); i++) {
                int height = curr.get(i)[1];
                int base = i + 1;
                maxArea = Math.max(maxArea, height * base);
            }
            prev = curr;
        }

        return maxArea;
    }

    public int largestSubmatrix(int[][] matrix) {
        return sol2(matrix);
    }
}