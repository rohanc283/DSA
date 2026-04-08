class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long xorA = 0, xorB = 0;
        for (long i = 49; i >= n; i--) {
            boolean a_ith_bit = ((a >> i) & 1) >= 1;
            boolean b_ith_bit = ((b >> i) & 1) >= 1;
            if (a_ith_bit) {
                xorA |= (1L << i);
            }
            if (b_ith_bit) {
                xorB |= (1L << i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            boolean a_ith_bit = ((a >> i) & 1) >= 1;
            boolean b_ith_bit = ((b >> i) & 1) >= 1;
            if (a_ith_bit == b_ith_bit) {
                xorA |= (1L << i);
                xorB |= (1L << i);
            } else {
                if (xorA > xorB) {
                    xorB |= (1L << i);
                } else {
                    xorA |= (1L << i);
                }
            }
        }
        int MOD = 1_000_000_007;
        xorA %= MOD;
        xorB %= MOD;
        int res = (int) ((xorA * xorB) % MOD);
        return res;
    }
}