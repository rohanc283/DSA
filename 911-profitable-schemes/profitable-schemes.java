class Solution {

    int N, M;
    Integer[][][] dp;
    int MOD = 1_000_000_007;

    private int solve(int[] group, int[] profit, int i, int prof, int people) {

        if (people > N)
            return 0;

        if (i == group.length)
            return prof >= M ? 1 : 0;

        if (dp[i][prof][people] != null)
            return dp[i][prof][people];

        int skip = solve(group, profit, i + 1, prof, people);

        int take = solve(
                group,
                profit,
                i + 1,
                Math.min(prof + profit[i], M),
                people + group[i]);

        return dp[i][prof][people] = (skip + take) % MOD;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        N = n;
        M = minProfit;
        dp = new Integer[group.length][M + 1][n + 1];
        return solve(group, profit, 0, 0, 0);
    }
}