class Solution {
    public boolean isPoss(int[] bloomDay, int bouquets, int k, int maxDays) {
        int n = bloomDay.length;
        int bouquetCount = 0;
        int adjacentCount = 0;
        for (int i = 0; i < n; i++) {
            boolean isBloomed = bloomDay[i] <= maxDays;
            boolean isPrevBloomed = adjacentCount == 0 || bloomDay[i - 1] <= maxDays;
            if (isBloomed && isPrevBloomed) {
                adjacentCount++;
            } else if (isBloomed && !isPrevBloomed) {
                adjacentCount = 1;
            } else if (!isBloomed) {
                adjacentCount = 0;
            }

            if (adjacentCount == k) {
                bouquetCount++;
                adjacentCount = 0;
            }
        }
        return bouquetCount >= bouquets;
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