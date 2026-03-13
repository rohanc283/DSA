class Solution {
    public boolean isPoss(int[] workerTimes, int mountainHeight, long maxTime) {
        long removed = 0;

        for (long t : workerTimes) {
            long k = (long) (Math.sqrt(2.0 * maxTime / t + 0.25) - 0.5);
            removed += k;
            if (removed >= mountainHeight)
                return true;
        }

        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 1;
        long h = 0;
        for (int workerTime : workerTimes)
            h = Math.max(h, workerTime);
        long sum = ((long) mountainHeight * (mountainHeight + 1)) / 2;
        h *= sum;
        long res = 0;

        while (l <= h) {
            long mid = l + (h - l) / 2;
            if (isPoss(workerTimes, mountainHeight, mid)) {
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}