class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {

        int[][] grid = new int[n][n];

        for (int[] row : grid)
            Arrays.fill(row, 1);

        for (int[] m : mines)
            grid[m[0]][m[1]] = 0;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count = grid[i][j] == 0 ? 0 : count + 1;
                dp[i][j] = count;
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                count = grid[i][j] == 0 ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                count = grid[i][j] == 0 ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        int ans = 0;

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = n - 1; i >= 0; i--) {
                count = grid[i][j] == 0 ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}