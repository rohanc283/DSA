class Solution {

    Integer[][][][] dp;

    private int solve(String s, int i, int prev, int freq, int k) {
        if (k < 0)
            return Integer.MAX_VALUE / 2;
        if (i == s.length())
            return 0;
        if (freq > 100)
            freq = 100;
        if (dp[i][prev][freq][k] != null)
            return dp[i][prev][freq][k];
        char c = s.charAt(i);
        int delete = solve(s, i + 1, prev, freq, k - 1);
        int keep;
        if (c - 'a' != prev) {
            keep = 1 + solve(s, i + 1, c - 'a', 1, k);
        } else {
            int add = 0;
            if (freq == 1 || freq == 9 || freq == 99)
                add = 1;

            keep = add + solve(s, i + 1, prev, freq + 1, k);
        }
        return dp[i][prev][freq][k] = Math.min(delete, keep);
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        dp = new Integer[n][27][101][k + 1];
        return solve(s, 0, 26, 0, k);
    }
}