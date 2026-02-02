class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for (int num : nums)
            maxi = Math.max(maxi, num);

        int s = 0, e = 0;
        int res = 0;
        while (e < n) {
            if (nums[e] != maxi) {
                res = Math.max(res, e - s);
                s = e + 1;
            }
            e++;
        }
        res = Math.max(res, e - s);
        return res;
    }
}