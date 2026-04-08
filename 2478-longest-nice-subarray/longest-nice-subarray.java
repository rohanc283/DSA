class Solution {
    public int longestNiceSubarray(int[] nums) {
        int mask = 0;
        int i = 0;
        int maxLen = 0;
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            while ((mask & num) != 0 && i < j) {
                mask ^= nums[i++];
            }
            mask |= num;
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}