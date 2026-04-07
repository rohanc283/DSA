class Solution {
    public int minOperations(int[] nums, int k) {
        int flip = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = 0;
            for (int num : nums) {
                int currBit = ((num >> i) & 1) >= 1 ? 1 : 0;
                bit ^= currBit;
            }
            int kthBit = ((k >> i) & 1) >= 1 ? 1 : 0;
            if (bit != kthBit)
                flip++;
        }
        return flip;
    }
}