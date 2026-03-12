class Solution {

    Set<String> dict;
    Boolean[] dp;
    int n;

    private boolean solve(String s, int i) {
        if (i == n)
            return true;

        if (dp[i] != null)
            return dp[i];

        for (int len = 1; i + len <= n; len++) {
            String temp = s.substring(i, i + len);
            if (dict.contains(temp) && solve(s, i + len)) {
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dict = new HashSet<>(wordDict);
        dp = new Boolean[n];
        return solve(s, 0);
    }
}