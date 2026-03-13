class Solution {
    int n;
    Integer[][] dp;

    private int solve(String s, int l, int r) {
        if (l > r)
            return 0;
        if (l == r)
            return 1;

        if (dp[l][r] != null)
            return dp[l][r];

        int i = l + 1;
        while (i <= r && s.charAt(i) == s.charAt(l))
            i++;
        if (i == r + 1)
            return 1;
        int basic = 1 + solve(s, i, r);
        int greed = Integer.MAX_VALUE;
        for (int j = i; j <= r; j++) {
            if (s.charAt(j) == s.charAt(l)) {
                greed = Math.min(greed, solve(s, i, j - 1) + solve(s, j, r));
            }
        }
        return dp[l][r] = Math.min(basic, greed);
    }

    public int strangePrinter(String s) {
        n = s.length();
        dp = new Integer[n][n];
        return solve(s, 0, n - 1);
    }
}