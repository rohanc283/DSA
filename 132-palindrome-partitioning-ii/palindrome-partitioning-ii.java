class Solution {
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    int n;

    Boolean[][] dp;
    Integer[] dp2;

    private int solve(String s, int idx) {
        if (idx >= n) {
            return 0;
        }
        if (dp2[idx] != null)
            return dp2[idx];
        int ans = Integer.MAX_VALUE;
        for (int i = idx; i < n; i++) {
            if (dp[idx][i]) {
                ans = Math.min(ans, 1 + solve(s, i + 1));
            }
        }
        return dp2[idx] = ans;
    }

    public int minCut(String s) {
        n = s.length();
        dp = new Boolean[n][n];
        dp2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], false);
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return solve(s, 0) - 1;
    }
}