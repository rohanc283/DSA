class Solution {
    public boolean isPoss(int[] houses, int[] heaters, int radius) {
        int i = 0, j = 0;
        int n1 = houses.length, n2 = heaters.length;
        while (i < n1 && j < n2) {
            int d = Math.abs(houses[i] - heaters[j]);
            if (d <= radius) {
                i++;
            } else {
                j++;
            }
        }
        return i >= n1;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0, h = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        int res = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(houses, heaters, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}