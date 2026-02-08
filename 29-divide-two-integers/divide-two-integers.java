class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == dividend)
            return 1;
        boolean sign = true;
        if (dividend < 0 && divisor > 0)
            sign = false;
        if (dividend > 0 && divisor < 0)
            sign = false;
        long dd = Math.abs((long) dividend), dv = Math.abs((long) divisor);
        int res = 0;
        while (dd >= dv) {
            int cnt = 0;
            while (dd >= dv << (1 + cnt)) {
                cnt++;
            }
            dd -= (dv << cnt);
            res += (1 << cnt);
        }
        if (res == (1 << 31)) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign ? res : -res;
    }
}