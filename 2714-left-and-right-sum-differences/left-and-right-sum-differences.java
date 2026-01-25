class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] lSums = new int[n];
        int[] rSums = new int[n];

        int lSum = 0, rSum = 0;
        for (int i = 0; i < n; i++) {
            lSums[i] = lSum;
            rSums[n - i - 1] = rSum;
            lSum += nums[i];
            rSum += nums[n - i - 1];
        }

        for (int i = 0; i < n; i++) {
            lSums[i] = Math.abs(lSums[i] - rSums[i]);
        }
        return lSums;
    }
}