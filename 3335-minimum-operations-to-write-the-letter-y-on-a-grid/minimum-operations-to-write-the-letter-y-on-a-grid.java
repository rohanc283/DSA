class Solution {
    public int findCost(int[][] grid, int yVal, int oVal) {
        int n = grid.length, centre = n / 2;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j && i < centre && j < centre)
                        || (i + j == n - 1 && i < centre && j > centre)
                        || (i >= centre && j == centre)) {
                    if (grid[i][j] != yVal)
                        cost++;
                } else {
                    if (grid[i][j] != oVal)
                        cost++;
                }
            }
        }
        return cost;
    }

    public int minimumOperationsToWriteY(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int[] values = { 0, 1, 2 };

        for (int yVal : values) {
            for (int oVal : values) {
                if (yVal == oVal)
                    continue;
                ans = Math.min(ans, findCost(grid, yVal, oVal));
            }
        }

        return ans;
    }
}