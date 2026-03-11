class Solution {
    String word1, word2;
    int N1, N2;
    Integer[][] dp;

    private int solve(int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = 1 + solve(i - 1, j - 1);
        } else {
            ans = Math.max(solve(i - 1, j), solve(i, j - 1));
        }
        return dp[i][j] = ans;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        N1 = text1.length();
        N2 = text2.length();
        word1 = text1;
        word2 = text2;
        dp = new Integer[N1][N2];
        return solve(N1 - 1, N2 - 1);
    }
}