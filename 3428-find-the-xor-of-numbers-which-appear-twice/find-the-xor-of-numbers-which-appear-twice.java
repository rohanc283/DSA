class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int[] freq = new int[51];
        for (int num : nums)
            freq[num]++;
        int res = 0;
        for (int i = 1; i < 51; i++) {
            if (freq[i] > 1)
                res ^= i;
        }
        return res;
    }
}