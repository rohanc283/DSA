class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int leftBit = (int) (left >> i) & 1;
            int rightBit = (int) (right >> i) & 1;
            if (leftBit == rightBit) {
                res |= (leftBit << i);
            } else {
                break;
            }
        }
        return res;
    }
}