class Solution {
    public boolean isPoss(int[] ranks, int cars, long time) {
        int carsCount = 0;
        for (int rank : ranks) {
            carsCount += Math.sqrt(time / rank);
        }
        return carsCount >= cars;
    }

    public long repairCars(int[] ranks, int cars) {
        long l = 1, h = 0;
        for (int rank : ranks)
            h = Math.max(h, rank);
        h = h * cars * cars;
        long res = -1;
        while (l <= h) {
            long m = l + (h - l) / 2;
            if (isPoss(ranks, cars, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}