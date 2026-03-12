class Solution {

    Integer[] dp;

    private int solve(String s, int i) {
        if (i == s.length())
            return 0;

        if (dp[i] != null)
            return dp[i];

        int[] freq = new int[26];
        int maxFreq = 0;
        int unique = 0;

        int ans = Integer.MAX_VALUE;

        for (int j = i; j < s.length(); j++) {

            int idx = s.charAt(j) - 'a';

            if (freq[idx] == 0)
                unique++;

            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);

            int length = j - i + 1;
            if (length == unique * maxFreq) {
                ans = Math.min(ans, 1 + solve(s, j + 1));
            }
        }

        return dp[i] = ans;
    }

    public int minimumSubstringsInPartition(String s) {
        dp = new Integer[s.length()];
        return solve(s, 0);
    }
}