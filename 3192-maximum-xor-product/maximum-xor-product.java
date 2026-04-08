class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long xor = 0;

        for (int i = n - 1; i >= 0; i--) {
            int aBit = (int) ((a >> i) & 1);
            int bBit = (int) ((b >> i) & 1);

            if (aBit == bBit) {
                if (aBit == 0) {
                    xor |= (1L << i);
                }
            } else {
                long xor1 = xor ^ (1L << i);
                long xor2 = xor;

                long A1 = a ^ xor1;
                long B1 = b ^ xor1;

                long A2 = a ^ xor2;
                long B2 = b ^ xor2;

                long diff1 = Math.abs(A1 - B1);
                long diff2 = Math.abs(A2 - B2);

                if (diff1 < diff2) {
                    xor = xor1;
                } else {
                    xor = xor2;
                }
            }
        }

        int MOD = 1_000_000_007;
        long an = (a ^ xor) % MOD;
        long bn = (b ^ xor) % MOD;

        return (int) ((an * bn) % MOD);
    }
}