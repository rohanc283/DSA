class Solution {
    public int binaryGap(int n) {
        int prev_set_bit = -1;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            boolean isSetBit = (1 & (n >> i)) == 1;
            if (isSetBit) {
                if (prev_set_bit == -1) {
                    prev_set_bit = i;
                } else {
                    res = Math.max(res, prev_set_bit - i);
                    prev_set_bit = i;
                }
            }
        }
        return res;
    }
}