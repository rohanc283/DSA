class Solution {
    int M, N;
    Integer[][] dp;

    private int solve(String s1, String s2, int i, int j) {
        if (i >= M && j >= N) {
            return 0;
        }
        if (i >= M && j < N) {
            int ascii = 0;
            while (j < N) {
                ascii += s2.charAt(j++);
            }
            return ascii;
        }
        if (i < M && j >= N) {
            int ascii = 0;
            while (i < M) {
                ascii += s1.charAt(i++);
            }
            return ascii;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = solve(s1, s2, i + 1, j + 1);
        } else {
            int ascii1 = s1.charAt(i) + solve(s1, s2, i + 1, j);
            int ascii2 = s2.charAt(j) + solve(s1, s2, i, j + 1);
            ans = Math.min(ascii1, ascii2);
        }
        return dp[i][j] = ans;
    }

    public int minimumDeleteSum(String s1, String s2) {
        M = s1.length();
        N = s2.length();
        dp = new Integer[M][N];
        return solve(s1, s2, 0, 0);
    }
}