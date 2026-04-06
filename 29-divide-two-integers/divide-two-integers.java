class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = true;
        if (dividend < 0 && divisor >= 0)
            sign = false;
        if (dividend >= 0 && divisor < 0)
            sign = false;
        long dd = dividend, dv = divisor;
        dd = Math.abs(dd);
        dv = Math.abs(dv);
        if (dd == dv)
            return sign ? 1 : -1;
        long ans = 0;
        System.out.println(dd + " " + dv);
        while (dd >= dv) {
            int cnt = 0;
            while (dd >= (dv << (cnt + 1))) {
                cnt++;
            }

            dd -= (dv << cnt);
            ans += (1 << cnt);
        }
        System.out.println(ans);
        if (ans == Integer.MIN_VALUE) {
            return (int) (sign ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        }
        return (int) (sign ? ans : -ans);
    }
}