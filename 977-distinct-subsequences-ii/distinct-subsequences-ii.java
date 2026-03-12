class Solution {
    Integer[] dp;
    int MOD = 1_000_000_007;
    int[] last = new int[26];

    private int solve(String s, int i) {
        if (i == 0)
            return 1;

        if (dp[i] != null)
            return dp[i];

        int res = (2 * solve(s, i - 1)) % MOD;

        char c = s.charAt(i - 1);

        if (last[c - 'a'] != -1) {
            int j = last[c - 'a'];
            res = (res - solve(s, j) + MOD) % MOD;
        }

        last[c - 'a'] = i - 1;

        return dp[i] = res;
    }

    public int distinctSubseqII(String s) {
        Arrays.fill(last, -1);
        dp = new Integer[s.length() + 1];
        int ans = solve(s, s.length());
        return (ans - 1 + MOD) % MOD;
    }
}