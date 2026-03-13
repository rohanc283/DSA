class Solution {
    int[][] cost;
    Integer[][] dp;
    int n;

    int solve(int i, int k, int[] houses) {
        if (i == n && k == 0)
            return 0;

        if (i == n || k == 0)
            return 1000000;

        if (dp[i][k] != null)
            return dp[i][k];

        int ans = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            ans = Math.min(ans,
                    cost[i][j] + solve(j + 1, k - 1, houses));
        }

        return dp[i][k] = ans;
    }

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        n = houses.length;
        cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = (i + j) / 2;
                for (int x = i; x <= j; x++)
                    cost[i][j] += Math.abs(houses[x] - houses[mid]);
            }
        }

        dp = new Integer[n][k + 1];
        return solve(0, k, houses);
    }
}