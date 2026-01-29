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
        int zeroOneCost = findCost(grid, 0, 1);
        int zeroTwoCost = findCost(grid, 0, 2);

        int yZeroCost = Math.min(zeroOneCost, zeroTwoCost);

        int oneZeroCost = findCost(grid, 1, 0);
        int oneTwoCost = findCost(grid, 1, 2);

        int yOneCost = Math.min(oneZeroCost, oneTwoCost);

        int twoZeroCost = findCost(grid, 2, 0);
        int twoOneCost = findCost(grid, 2, 1);

        int yTwoCost = Math.min(twoZeroCost, twoOneCost);

        int ans = Math.min(yZeroCost, Math.min(yOneCost, yTwoCost));
        return ans;
    }
}