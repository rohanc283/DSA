class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length, i = 0, j = 0;
        int mask = 0, ans = 0;
        while (j < n) {
            while (i < j && (nums[j] & mask) != 0) {
                mask ^= nums[i];
                i++;
            }
            mask |= nums[j];
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}