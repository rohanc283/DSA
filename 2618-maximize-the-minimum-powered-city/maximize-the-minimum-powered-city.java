class Solution {
    private boolean isPoss(long[] diff, int n, int r, int k, long m) {
        long[] tempDiff = diff.clone();
        for (int i = 0; i < n; i++) {
            tempDiff[i] = diff[i];
        }
        long cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += tempDiff[i];
            if (cumSum < m) {
                long need = m - cumSum;
                if (need > k)
                    return false;
                k -= need;
                cumSum += need;
                if (i + (2 * r) + 1 < n)
                    tempDiff[i + (2 * r) + 1] -= need;
            }
        }
        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] diff = new long[n];
        long l = Integer.MAX_VALUE, h = k;
        for (int i = 0; i < n; i++) {
            l = Math.min(l, stations[i]);
            h += stations[i];
            diff[Math.max(0, i - r)] += stations[i];
            if (i + r + 1 < n) {
                diff[i + r + 1] -= stations[i];
            }
        }
        long res = 0;
        while (l <= h) {
            long m = l + (h - l) / 2;
            if (isPoss(diff, n, r, k, m)) {
                res = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return res;
    }
}