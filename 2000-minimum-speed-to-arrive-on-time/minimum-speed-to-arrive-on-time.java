class Solution {
    public boolean isPoss(int[] dist, double hour, int speed) {
        double currHour = 0;
        for (int i = 0; i < dist.length; i++) {
            currHour = Math.ceil(currHour);
            double time = ((double) dist[i] / (double) speed);
            if (currHour + time > hour)
                return false;
            currHour += time;
        }
        return currHour <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, h = 10000000;
        System.out.println(h);
        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(dist, hour, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}