class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        // calculate left sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            leftSum[i] = sum;
        }

        // calculate right sum
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            rightSum[i] = sum;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int rD = n - i - 1;
            int rS = leftSum[n - 1] - leftSum[i];
            int rA = rS - (nums[i] * rD);

            int lD = i - 0;
            int lS = rightSum[0] - rightSum[i];
            int lA = (nums[i] * lD) - lS;
            ans[i] = lA + rA;
        }
        return ans;
    }
}