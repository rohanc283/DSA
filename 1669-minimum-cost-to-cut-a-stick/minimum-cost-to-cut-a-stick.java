class Solution {
    Integer[][] dp;

    private int solve(int[] cuts, int i, int j) {
        if (i + 1 >= j)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int left = solve(cuts, i, k);
            int right = solve(cuts, k, j);
            ans = Math.min(ans, (cuts[j] - cuts[i]) + left + right);
        }
        return dp[i][j] = ans;
    }

    public int minCost(int n, int[] cuts) {
        int m = cuts.length + 2;
        int[] newCuts = new int[m];
        newCuts[0] = 0;
        for (int i = 0; i < cuts.length; i++) {
            newCuts[i + 1] = cuts[i];
        }
        newCuts[m - 1] = n;
        Arrays.sort(newCuts);
        dp = new Integer[m][m];
        return solve(newCuts, 0, m - 1);
    }
}