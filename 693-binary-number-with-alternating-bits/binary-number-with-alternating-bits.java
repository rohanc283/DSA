class Solution {
    public boolean sol1(int n) {
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

    public boolean sol2(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }

    public boolean hasAlternatingBits(int n) {
        return sol2(n);
    }
}