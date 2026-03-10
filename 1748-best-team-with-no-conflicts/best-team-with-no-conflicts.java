class Solution {

    Integer[][] dp;

    private int solve(int[][] teams, int curr, int prev, int n) {

        if (curr == n)
            return 0;

        if (dp[curr][prev + 1] != null)
            return dp[curr][prev + 1];

        int skip = solve(teams, curr + 1, prev, n);

        int take = 0;

        if (prev == -1 || teams[curr][1] >= teams[prev][1]) {
            take = teams[curr][1] + solve(teams, curr + 1, curr, n);
        }

        return dp[curr][prev + 1] = Math.max(skip, take);
    }

    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;
        int[][] teams = new int[n][2];

        for (int i = 0; i < n; i++) {
            teams[i][0] = ages[i];
            teams[i][1] = scores[i];
        }

        Arrays.sort(teams, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        dp = new Integer[n][n + 2];
        return solve(teams, 0, -1, n);
    }
}