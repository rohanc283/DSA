class Solution {
    Integer[][][] dp;

    private int solve(String[] strs, int[] zeros, int i, int m, int n) {
        if (i >= strs.length)
            return 0;
        int zero = zeros[i];
        int one = strs[i].length() - zero;

        if (dp[i][m][n] != null)
            return dp[i][m][n];

        if (zero > m || one > n)
            return dp[i][m][n] = solve(strs, zeros, i + 1, m, n);

        int take = 1 + solve(strs, zeros, i + 1, m - zero, n - one);
        int skip = solve(strs, zeros, i + 1, m, n);
        return dp[i][m][n] = Math.max(take, skip);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zeros = new int[len];
        for (int i = 0; i < len; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeros[i]++;
                }
            }
        }
        dp = new Integer[len][m + 1][n + 1];
        return solve(strs, zeros, 0, m, n);
    }
}