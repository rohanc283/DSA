class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long currSum = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            currSum += nums[r];
            if ((long) (r - l + 1) * nums[r] - currSum > k) {
                currSum -= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}