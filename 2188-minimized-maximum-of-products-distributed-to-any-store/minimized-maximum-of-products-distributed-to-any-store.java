class Solution {
    private boolean isPoss(int n, int[] quantities, int maxProducts) {
        long totalProducts = 0;
        for (int quantity : quantities) {
            totalProducts += ((quantity + maxProducts - 1) / maxProducts);
            if (totalProducts > n)
                return false;
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, h = 0;
        for (int quantity : quantities)
            h = Math.max(h, quantity);
        int res = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(n, quantities, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}