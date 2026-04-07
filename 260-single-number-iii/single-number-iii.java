class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;

        xor = xor & (xor ^ (xor - 1));
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & xor) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}