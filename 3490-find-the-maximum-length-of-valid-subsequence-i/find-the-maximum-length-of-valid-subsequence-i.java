class Solution {
    private int sol1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], 1);
        }
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % 2;
                dp[mod][i] = Math.max(dp[mod][i], 1 + dp[mod][j]);
                maxLen = Math.max(maxLen, dp[mod][i]);
            }
        }
        return maxLen;
    }

    private int sol2(int[] nums) {
        int oddCount = 0, evenCount = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        int parity = nums[0] % 2;
        int alternate = 1;
        for (int i = 1; i < nums.length; i++) {
            int currParity = nums[i] % 2;
            if (parity != currParity) {
                alternate++;
                parity = currParity;
            }
        }
        return Math.max(alternate, Math.max(oddCount, evenCount));
    }

    public int maximumLength(int[] nums) {
        return sol2(nums);
    }
}