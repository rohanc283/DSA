class Solution {
    public boolean isPoss(int[] bloomDay, int m, int k, int maxDays) {
        int bouquets = 0;
        int flowers = 0;

        for (int day : bloomDay) {
            if (day <= maxDays) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n)
            return -1;
        int low = Integer.MAX_VALUE, high = 0;
        for (int num : bloomDay) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPoss(bloomDay, m, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}