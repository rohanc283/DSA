class Solution {

    int total;
    Integer[][] dp;

    private int solve(int[] stones, int i, int sum) {

        if (i == stones.length) {
            int other = total - sum;
            return Math.abs(other - sum);
        }

        if (dp[i][sum] != null)
            return dp[i][sum];

        int take = solve(stones, i + 1, sum + stones[i]);

        int skip = solve(stones, i + 1, sum);

        return dp[i][sum] = Math.min(take, skip);
    }

    public int lastStoneWeightII(int[] stones) {

        total = 0;
        for (int s : stones)
            total += s;

        dp = new Integer[stones.length][total + 1];

        return solve(stones, 0, 0);
    }
}