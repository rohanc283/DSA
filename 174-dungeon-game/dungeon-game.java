class Solution {
    int M, N;
    Integer[][] dp;

    private int solve(int[][] dungeon, int i, int j) {
        if (i == M - 1 && j == N - 1) {
            if (dungeon[i][j] <= 0) {
                return Math.abs(dungeon[i][j]) + 1;
            } else {
                return 1;
            }
        }

        if (i >= M || j >= N)
            return Integer.MAX_VALUE;

        if (dp[i][j] != null)
            return dp[i][j];

        int curr = dungeon[i][j];
        int right = solve(dungeon, i, j + 1);
        int down = solve(dungeon, i + 1, j);
        int res = Math.min(right, down) - dungeon[i][j];
        return dp[i][j] = Math.max(1, res);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        M = dungeon.length;
        N = dungeon[0].length;
        dp = new Integer[M][N];
        return solve(dungeon, 0, 0);
    }
}