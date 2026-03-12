class Solution {
    Integer[][] dp;

    private int solve(String s, int i, int j) {
        if (i >= j)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        if (s.charAt(i) == s.charAt(j)) {
            ans = solve(s, i + 1, j - 1);
        } else {
            ans = 1 + Math.min(solve(s, i + 1, j), solve(s, i, j - 1));
        }
        return dp[i][j] = ans;
    }

    public int minInsertions(String s) {
        int n = s.length();
        dp = new Integer[n][n];
        return solve(s, 0, n - 1);
    }
}