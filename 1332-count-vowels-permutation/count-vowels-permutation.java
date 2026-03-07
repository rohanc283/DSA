class Solution {

    int MOD = 1_000_000_007;
    Integer[][] dp;

    int a = 0, e = 1, i = 2, o = 3, u = 4;

    private int solve(int c, int n) {

        if (n == 0)
            return 1;

        if (dp[c][n] != null)
            return dp[c][n];

        long ans = 0;

        if (c == a) {
            ans = solve(e, n - 1);
        } else if (c == e) {
            ans = (long) solve(a, n - 1) + solve(i, n - 1);
        } else if (c == i) {
            ans = (long) solve(a, n - 1) + solve(e, n - 1)
                    + solve(o, n - 1) + solve(u, n - 1);
        } else if (c == o) {
            ans = (long) solve(i, n - 1) + solve(u, n - 1);
        } else {
            ans = solve(a, n - 1);
        }

        return dp[c][n] = (int) (ans % MOD);
    }

    public int countVowelPermutation(int n) {

        dp = new Integer[5][n + 1];

        long ans = 0;

        ans += solve(a, n - 1);
        ans += solve(e, n - 1);
        ans += solve(i, n - 1);
        ans += solve(o, n - 1);
        ans += solve(u, n - 1);

        return (int) (ans % MOD);
    }
}