class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 31; i >= 0; i--) {
            int aBit = (int) (a >> i) & 1;
            int bBit = (int) (b >> i) & 1;
            int cBit = (int) (c >> i) & 1;
            if ((aBit | bBit) != cBit) {
                if (cBit == 0) {
                    flips += aBit + bBit;
                } else {
                    flips++;
                }
            }
        }
        return flips;
    }
}