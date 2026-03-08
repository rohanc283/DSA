class Solution {
    int MOD = 1_000_000_007;
    Integer[][][] dp;

    private int solve(int[] locations, int start, int finish, int fuel) {
        if (fuel < 0)
            return 0;
        if (dp[start][finish][fuel] != null)
            return dp[start][finish][fuel];
        int ans = start == finish ? 1 : 0;
        for (int i = 0; i < locations.length; i++) {
            if (i == start)
                continue;
            int fuelNeeded = Math.abs(locations[start] - locations[i]);
            if (fuelNeeded <= fuel) {
                ans = (ans + solve(locations, i, finish, fuel - fuelNeeded)) % MOD;
            }
        }
        return dp[start][finish][fuel] = ans;
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        dp = new Integer[n][n][fuel + 1];
        return solve(locations, start, finish, fuel);
    }
}