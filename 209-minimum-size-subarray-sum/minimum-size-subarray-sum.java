class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int s = 0, e = 0, sum = 0;
        int res = Integer.MAX_VALUE;
        while (e < n) {
            sum += nums[e];
            while (sum >= target) {
                res = Math.min(res, e - s + 1);
                sum -= nums[s++];
            }
            e++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}