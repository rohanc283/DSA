class Solution {
    int[] dp;

    public boolean solve(int[] nums, int i, int n) {
        if (i >= n - 1)
            return true;
        if (dp[i] != -1)
            return dp[i] == 0 ? false : true;
        for (int j = 0; j < nums[i]; j++) {
            if (solve(nums, i + j + 1, n)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }

    public boolean sol1(int[] nums) {
        dp = new int[10001];
        Arrays.fill(dp, -1);
        return solve(nums, 0, nums.length);
    }

    public boolean canJump(int[] nums) {
        return sol1(nums);
    }
}