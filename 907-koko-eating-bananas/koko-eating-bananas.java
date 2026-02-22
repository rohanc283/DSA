class Solution {
    public boolean isPoss(int[] piles, int hours, int speed) {
        int n = piles.length;
        int currTime = 0;
        for (int i = 0; i < n; i++) {
            int time = (piles[i] + speed - 1) / speed;
            if (currTime + time > hours)
                return false;
            currTime += time;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }
        int res = 0;
        while (low <= high) {
            int m = low + (high - low) / 2;
            if (isPoss(piles, h, m)) {
                res = m;
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return res;
    }
}