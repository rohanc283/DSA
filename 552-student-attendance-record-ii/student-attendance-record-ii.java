class Solution {

    Integer[][][] dp;
    int MOD = 1_000_000_007;

    public int solve(int absentCount, int lateConsecutiveCount, int rem) {

        if (absentCount > 1)
            return 0;

        if (lateConsecutiveCount > 2)
            return 0;

        if (rem == 0)
            return 1;

        if (dp[absentCount][lateConsecutiveCount][rem] != null)
            return dp[absentCount][lateConsecutiveCount][rem];

        long absent = solve(absentCount + 1, 0, rem - 1);
        long present = solve(absentCount, 0, rem - 1);
        long late = solve(absentCount, lateConsecutiveCount + 1, rem - 1);

        return dp[absentCount][lateConsecutiveCount][rem] = (int) ((absent + present + late) % MOD);
    }

    public int checkRecord(int n) {
        dp = new Integer[2][3][n + 1];
        return solve(0, 0, n);
    }
}