class Solution {
    Integer[][] dp;

    private int solve(int[] nums, int i, int j) {
        if (i > j)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        for (int k = i; k <= j; k++) {
            int curr = (nums[k] * nums[i - 1] * nums[j + 1]) +
                    solve(nums, i, k - 1) + solve(nums, k + 1, j);
            ans = Math.max(ans, curr);
        }
        return dp[i][j] = ans;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int m = n + 2;
        int[] baloons = new int[m];
        baloons[0] = 1;
        for (int i = 0; i < n; i++) {
            baloons[i + 1] = nums[i];
        }
        baloons[m - 1] = 1;
        dp = new Integer[m][m];
        return solve(baloons, 1, m - 2);
    }
}