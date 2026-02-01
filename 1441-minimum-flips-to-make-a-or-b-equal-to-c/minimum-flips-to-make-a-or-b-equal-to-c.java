class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int a_ith_bit = (a & (1 << i)) >= 1 ? 1 : 0;
            int b_ith_bit = (b & (1 << i)) >= 1 ? 1 : 0;
            int c_ith_bit = (c & (1 << i)) >= 1 ? 1 : 0;
            int aOrB = a | b;
            aOrB = (aOrB & (1 << i)) >= 1 ? 1 : 0;
            if (aOrB != c_ith_bit) {
                if (aOrB == 1 && c_ith_bit == 0) {
                    if (a_ith_bit == 1)
                        flips++;
                    if (b_ith_bit == 1)
                        flips++;
                } else {
                    flips++;
                }
            }

        }
        return flips;
    }
}