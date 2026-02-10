class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, s = 0, zeros = 0;
        int res = 0;
        for (int e = 0; e < n; e++) {
            if (nums[e] == 0)
                zeros++;
            while (zeros > 1) {
                if (nums[s++] == 0)
                    zeros--;
            }
            res = Math.max(res, e - s);
        }
        return res;
    }
}