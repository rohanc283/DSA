class Solution {
    int M, N;
    Integer[][] dp;

    private int solve(String s, String t, int i, int j) {
        if (j >= N)
            return 1;
        if (i >= M && j < N)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans = solve(s, t, i + 1, j + 1) + solve(s, t, i + 1, j);
        } else {
            ans = solve(s, t, i + 1, j);
        }
        return dp[i][j] = ans;
    }

    public int numDistinct(String s, String t) {
        M = s.length();
        N = t.length();
        dp = new Integer[M][N];
        return solve(s, t, 0, 0);
    }
}