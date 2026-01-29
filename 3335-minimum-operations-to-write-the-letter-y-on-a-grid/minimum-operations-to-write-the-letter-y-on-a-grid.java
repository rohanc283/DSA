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

    public int freqSol(int[][] grid) {
        int n = grid.length, centre = n / 2;

        int[] freqY = new int[3];
        int[] freqNonY = new int[3];
        int totalY = 0, totalNonY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isY = (i == j && i < centre) ||
                        (i + j == n - 1 && i < centre) ||
                        (i >= centre && j == centre);

                if (isY) {
                    freqY[grid[i][j]]++;
                    totalY++;
                } else {
                    freqNonY[grid[i][j]]++;
                    totalNonY++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int yVal = 0; yVal <= 2; yVal++) {
            for (int oVal = 0; oVal <= 2; oVal++) {
                if (yVal == oVal)
                    continue;
                int cost = (totalY - freqY[yVal]) + (totalNonY - freqNonY[oVal]);
                ans = Math.min(ans, cost);
            }
        }

        return ans;
    }

    public int minimumOperationsToWriteY(int[][] grid) {
        // int ans = Integer.MAX_VALUE;
        // int[] values = { 0, 1, 2 };

        // for (int yVal : values) {
        //     for (int oVal : values) {
        //         if (yVal == oVal)
        //             continue;
        //         ans = Math.min(ans, findCost(grid, yVal, oVal));
        //     }
        // }

        // return ans;
        return freqSol(grid);
    }
}