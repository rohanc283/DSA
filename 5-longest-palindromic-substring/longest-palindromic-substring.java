class Solution {

    public boolean isPalindrome(String s, int i, int j) {
        if (i >= j)
            return true;

        if (s.charAt(i) != s.charAt(j))
            return false;

        return isPalindrome(s, i + 1, j - 1);
    }

    private String sol1(String s) {
        int n = s.length();
        int maxLen = 0;
        int sp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp + maxLen);
    }

    private String sol2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int sp = 0;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && len == 2) {
                    dp[i][j] = true;
                    maxLen = 2;
                    sp = i;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp + maxLen);
    }

    public String longestPalindrome(String s) {
        return sol2(s);
    }
}