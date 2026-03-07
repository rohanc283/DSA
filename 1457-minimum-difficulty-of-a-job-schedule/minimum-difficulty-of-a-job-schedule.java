class Solution {
    Integer[][] dp;
    int n;

    private int solve(int[] difficulty, int i, int d) {
        if (d == 1) {
            int max = 0;
            while (i < n) {
                max = Math.max(max, difficulty[i++]);
            }
            return max;
        }
        if (dp[i][d] != null)
            return dp[i][d];
        int max = 0;
        int ans = Integer.MAX_VALUE;
        for (int j = i; j <= n - d; j++) {
            max = Math.max(max, difficulty[j]);
            int curr = max + solve(difficulty, j + 1, d - 1);
            ans = Math.min(ans, curr);
        }
        return dp[i][d] = ans;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        dp = new Integer[n][d + 1];
        int ans = solve(jobDifficulty, 0, d);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}