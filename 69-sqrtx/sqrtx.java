class Solution {
    public int mySqrt(int x) {
        long l = 1, h = x / 2 + 1;
        long res = 0;
        while (l <= h) {
            long m = l + (h - l) / 2;
            long val = m * m;
            if (val == x) {
                res = m;
                break;
            } else if (val < x) {
                res = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return (int) (res % 1_000_000_007);
    }
}