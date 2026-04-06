class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int zeros = 0, ones = 0;
            for (int num : nums) {
                if (((num >> i) & 1) >= 1)
                    ones++;
                else
                    zeros++;
            }
            total += zeros * ones;
        }
        return total;
    }
}