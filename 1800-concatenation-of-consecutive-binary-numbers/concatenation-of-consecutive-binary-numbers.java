class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int digits = 0;
        int MOD = 1_000_000_007;
        for (int num = 1; num <= n; num++) {
            if ((num & (num - 1)) == 0)
                digits++;
            res = ((res << digits) + num) % MOD;
        }
        return (int) res;
    }
}