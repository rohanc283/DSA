class Solution {

    int N;
    int offset;
    Integer[][] dp;

    private int solve(int[] nums, int i, int sum) {

        if (sum < -offset || sum > offset)
            return 0;

        if (i == N)
            return sum == 0 ? 1 : 0;

        if (dp[i][sum + offset] != null)
            return dp[i][sum + offset];

        int take = solve(nums, i + 1, sum - nums[i]);
        int skip = solve(nums, i + 1, sum + nums[i]);

        return dp[i][sum + offset] = take + skip;
    }

    public int findTargetSumWays(int[] nums, int target) {

        N = nums.length;

        int total = 0;
        for (int n : nums)
            total += n;

        offset = total;

        dp = new Integer[N][2 * total + 1];

        return solve(nums, 0, target);
    }
}