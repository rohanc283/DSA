class Solution {
    int M, N;
    Boolean[][] dp;

    private boolean solve(String s, String p, int i, int j) {
        if (i < 0 && j < 0)
            return true;

        if (i >= 0 && j < 0)
            return false;

        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (dp[i][j] != null)
            return dp[i][j];
            
        boolean ans = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = solve(s, p, i - 1, j - 1);
        } else if (p.charAt(j) == '*') {
            ans = solve(s, p, i - 1, j) || solve(s, p, i, j - 1);
        }
        return dp[i][j] = ans;
    }

    public boolean isMatch(String s, String p) {
        M = s.length();
        N = p.length();
        dp = new Boolean[M][N];
        return solve(s, p, M - 1, N - 1);
    }
}