class Solution {

    Integer[][] dp;
    int[] prefix;

    private int solve(int[] stones, int i, int j) {
        if (i == j)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int ans = 0;

        for (int k = i; k < j; k++) {

            int leftSum = prefix[k + 1] - prefix[i];
            int rightSum = prefix[j + 1] - prefix[k + 1];

            if (leftSum < rightSum) {
                ans = Math.max(ans, leftSum + solve(stones, i, k));
            } else if (leftSum > rightSum) {
                ans = Math.max(ans, rightSum + solve(stones, k + 1, j));
            } else {
                ans = Math.max(ans,
                        leftSum + solve(stones, i, k));
                ans = Math.max(ans,
                        rightSum + solve(stones, k + 1, j));
            }
        }

        return dp[i][j] = ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new Integer[n][n];
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + stoneValue[i];

        return solve(stoneValue, 0, n - 1);
    }
}