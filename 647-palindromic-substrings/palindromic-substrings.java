class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = n;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && len == 2) {
                    dp[i][j] = true;
                    res++;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}