class Solution {
    private boolean isPoss(int[] batteries, long n, long m) {
        long targetMin = n * m;
        long sum = 0;
        for (int i = 0; i < batteries.length; i++) {
            targetMin -= Math.min(batteries[i], m);
            if (targetMin <= 0)
                return true;
        }
        return false;
    }

    public long maxRunTime(int n, int[] batteries) {
        long l = Integer.MAX_VALUE, h = 0;
        for (int b : batteries) {
            l = Math.min(l, b);
            h += b;
        }

        long res = 0;
        while (l <= h) {
            long m = l + (h - l) / 2;
            if (isPoss(batteries, n, m)) {
                res = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return res;
    }
}