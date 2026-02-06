class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long k = 0;
        for (int x : nums) {
            if (x == 0) {
                k++;
                res += k;
            } else {
                k = 0;
            }
        }
        return res;
    }
}