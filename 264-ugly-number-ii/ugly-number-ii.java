class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int i2Ugly = arr[i2] * 2;
            int i3Ugly = arr[i3] * 3;
            int i5Ugly = arr[i5] * 5;
            int minUgly = Math.min(i2Ugly, Math.min(i3Ugly, i5Ugly));
            arr[i] = minUgly;
            if (i2Ugly == minUgly) {
                i2++;
            }
            if (i3Ugly == minUgly) {
                i3++;
            }
            if (i5Ugly == minUgly) {
                i5++;
            }
        }
        return arr[n];
    }
}