class Solution {
    Integer[] dp;

    private int solve(String s, int i) {
        if (i == 0)
            return 1;
        if (dp[i] != null)
            return dp[i];

        char prev = s.charAt(i - 1);
        char curr = s.charAt(i);

        if ((curr - prev == 1) || (prev == 'z' && curr == 'a')) {
            return dp[i] = solve(s, i - 1) + 1;
        }

        return dp[i] = 1;
    }

    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        dp = new Integer[n];
        int[] maxLen = new int[26];
        for (int i = 0; i < n; i++) {
            int len = solve(s, i);
            int idx = s.charAt(i) - 'a';
            maxLen[idx] = Math.max(len, maxLen[idx]);
        }
        int ans = 0;
        for (int x : maxLen)
            ans += x;
        return ans;
    }
}