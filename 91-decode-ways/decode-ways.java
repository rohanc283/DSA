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

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0);
    }
}