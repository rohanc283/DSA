class Solution {
    int MOD = 1_000_000_007;
    Integer[][][] dp;

    private int solve(int zeroLeft, int oneLeft, int prev, int limit) {
        if (zeroLeft == 0 && oneLeft == 0) {
            return 1;
        }
        if (dp[zeroLeft][oneLeft][prev] != null)
            return dp[zeroLeft][oneLeft][prev];
        int res = 0;
        if (prev == 1) {
            for (int i = 1; i <= Math.min(zeroLeft, limit); i++) {
                res = (res + solve(zeroLeft - i, oneLeft, 0, limit)) % MOD;
            }
        } else {
            for (int i = 1; i <= Math.min(oneLeft, limit); i++) {
                res = (res + solve(zeroLeft, oneLeft - i, 1, limit)) % MOD;
            }
        }
        return dp[zeroLeft][oneLeft][prev] = res;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero + 1][one + 1][2];
        int startWithOne = solve(zero, one, 1, limit);
        int startWithZero = solve(zero, one, 0, limit);
        return (startWithOne + startWithZero) % MOD;
    }
}