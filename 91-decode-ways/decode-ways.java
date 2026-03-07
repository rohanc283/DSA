class Solution {
    int[] dp;

    public int solve(String s, int idx) {
        int n = s.length();

        if (idx == n)
            return 1;

        if (s.charAt(idx) == '0')
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int ways = solve(s, idx + 1);

        if (idx + 1 < n) {
            int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if (num <= 26)
                ways += solve(s, idx + 2);
        }

        return dp[idx] = ways;
    }

    public int solveTab(String s) {
        dp = new int[s.length() + 2];
        int n = s.length();
        Arrays.fill(dp, 0);
        dp[n] = 1;
        dp[n + 1] = 1;
        for (int idx = n - 1; idx >= 0; idx--) {
            if (s.charAt(idx) == '0') continue;
            int ways = dp[idx + 1];
            if (idx + 1 < n) {
                int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
                if (num <= 26)
                    ways += dp[idx + 2];
            }
            dp[idx] = ways;
        }
        return dp[0];
    }

    public int numDecodings(String s) {
        // dp = new int[s.length()];
        // Arrays.fill(dp, -1);
        // return solve(s, 0);
        return solveTab(s);
    }
}