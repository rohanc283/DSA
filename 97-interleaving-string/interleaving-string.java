class Solution {
    int M, N, L;
    Integer[][] dp;

    private boolean solve(String s1, String s2, String s3, int i, int j) {
        if (i >= M && j >= N)
            return true;
        if (i < M && j < N && dp[i][j] != null)
            return dp[i][j] == 0 ? false : true;
        boolean ans = false;
        int k = i + j;
        if (i < M && j < N && s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
            ans = solve(s1, s2, s3, i + 1, j) ||
                    solve(s1, s2, s3, i, j + 1);
        } else {
            if (i < M && s1.charAt(i) == s3.charAt(k)) {
                ans = solve(s1, s2, s3, i + 1, j);
            }
            if (!ans && j < N && s2.charAt(j) == s3.charAt(k)) {
                ans = solve(s1, s2, s3, i, j + 1);
            }
        }

        if (i < M && j < N)
            dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        M = s1.length();
        N = s2.length();
        L = s3.length();

        if (M + N != L)
            return false;
        dp = new Integer[M][N];
        return solve(s1, s2, s3, 0, 0);
    }
}