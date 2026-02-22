class Solution {
    public boolean isPoss(int[] weights, int days, int capacity) {
        int n = weights.length;
        int daysCount = 0;
        int currCapacity = 0;
        for (int i = 0; i < n; i++) {
            if (currCapacity + weights[i] <= capacity) {
                currCapacity += weights[i];
            } else {
                daysCount++;
                if (daysCount >= days || weights[i] > capacity)
                    return false;
                currCapacity = weights[i];
            }
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MAX_VALUE, h = 0;
        for (int w : weights) {
            l = Math.min(l, w);
            h += w;
        }
        int res = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(weights, days, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}