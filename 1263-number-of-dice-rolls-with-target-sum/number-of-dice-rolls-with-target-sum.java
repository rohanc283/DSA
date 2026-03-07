class Solution {
    Integer[][] dp;

    private int solve(int n, int k, int target) {
        if (target < 0)
            return 0;
        if (target == 0)
            return n == 0 ? 1 : 0;
        if (n == 0)
            return 0;
        if (dp[n][target] != null)
            return dp[n][target];
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = (ans + solve(n - 1, k, target - i)) % 1_000_000_007;
        }
        return dp[n][target] = ans;
    }

    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[n + 1][target + 1];
        return solve(n, k, target);
    }
}