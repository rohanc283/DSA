class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    curr = Math.max(curr, dp[j]);
                }
            }
            dp[i] += curr;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}