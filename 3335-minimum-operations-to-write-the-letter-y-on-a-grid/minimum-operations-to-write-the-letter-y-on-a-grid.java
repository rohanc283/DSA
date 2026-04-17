class Solution {
    private boolean isY(int i, int j, int n, int centre) {
        return (j <= centre && i == j) || (i < centre && j == (n - i - 1)) || (i > centre && j == centre);
    }

    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int centre = n / 2;
        int[] freqY = new int[3];
        int[] freqNonY = new int[3];
        int totalY = 0, totalNonY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (isY(i, j, n, centre)) {
                    totalY++;
                    freqY[num]++;
                } else {
                    totalNonY++;
                    freqNonY[num]++;
                }
            }
        }
        int minOp = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;
                minOp = Math.min(minOp, (totalY - freqY[i]) + (totalNonY - freqNonY[j]));
            }
        }
        return minOp;
    }
}