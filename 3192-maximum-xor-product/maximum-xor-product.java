class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long xOrA = 0, xOrB = 0;
        for (long i = 49; i >= n; i--) {
            boolean a_ith_bit = ((a >> i) & 1) >= 1;
            boolean b_ith_bit = ((b >> i) & 1) >= 1;
            if (a_ith_bit) {
                xOrA |= (1L << i);
            }
            if (b_ith_bit) {
                xOrB |= (1L << i);
            }
        }
        for (long i = n - 1; i >= 0; i--) {
            boolean a_ith_bit = ((a >> i) & 1) >= 1;
            boolean b_ith_bit = ((b >> i) & 1) >= 1;
            if (a_ith_bit == b_ith_bit) {
                xOrA |= (1L << i);
                xOrB |= (1L << i);
            } else {
                if (xOrA > xOrB) {
                    xOrB |= (1L << i);
                } else {
                    xOrA |= (1L << i);
                }
            }
        }
        xOrA %= 1_000_000_007;
        xOrB %= 1_000_000_007;
        int res = (int) ((xOrA * xOrB) % 1_000_000_007);
        return res;
    }
}