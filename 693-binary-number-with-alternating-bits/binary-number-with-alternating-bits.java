class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean prevBit = (n & 1) >= 1;
        n = n >> 1;
        while (n > 0) {
            boolean currBit = (n & 1) >= 1;
            if (currBit == prevBit)
                return false;
            prevBit = currBit;
            n = n >> 1;
        }
        return true;
    }
}