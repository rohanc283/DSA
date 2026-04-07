class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int powerOf2Digits = 0;
        int MOD = 1_000_000_007;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0)
                powerOf2Digits++;
            res = ((res << powerOf2Digits) + i) % MOD;
        }
        return (int) res;
    }
}