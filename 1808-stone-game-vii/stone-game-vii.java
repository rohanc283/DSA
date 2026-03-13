class Solution {

    Integer[][] dp;
    int[] prefix;

    private int solve(int[] stones, int i, int j) {

        if (i == j)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int sum = prefix[j + 1] - prefix[i];

        int takeLeft = (sum - stones[i]) - solve(stones, i + 1, j);

        int takeRight = (sum - stones[j]) - solve(stones, i, j - 1);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }

    public int stoneGameVII(int[] stones) {

        int n = stones.length;

        dp = new Integer[n][n];
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + stones[i];

        return solve(stones, 0, n - 1);
    }
}