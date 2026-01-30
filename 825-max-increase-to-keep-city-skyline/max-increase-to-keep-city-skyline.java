class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMaxVal = new int[n];
        int[] colMaxVal = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMaxVal[i] = Math.max(rowMaxVal[i], grid[i][j]);
                colMaxVal[j] = Math.max(colMaxVal[j], grid[i][j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int h = Math.min(rowMaxVal[i], colMaxVal[j]);
                sum += (h - grid[i][j]);
            }
        }
        return sum;
    }
}