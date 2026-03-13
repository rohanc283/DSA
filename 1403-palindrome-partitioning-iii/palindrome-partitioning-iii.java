class Solution {

    int[][] cost;
    Integer[][] dp;
    int n;

    private int solve(String s, int i, int k) {
        if (k == 1)
            return cost[i][n - 1];

        if (dp[i][k] != null)
            return dp[i][k];

        int ans = Integer.MAX_VALUE;

        for (int j = i; j < n - k + 1; j++) {
            ans = Math.min(ans,
                    cost[i][j] + solve(s, j + 1, k - 1));
        }

        return dp[i][k] = ans;
    }

    public int palindromePartition(String s, int k) {
        n = s.length();
        cost = new int[n][n];
        dp = new Integer[n][k + 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                cost[i][j] = cost[i + 1][j - 1] +
                        (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }
        return solve(s, 0, k);
    }
}