class Solution {
    public int sol1(int n) {
        int res = 0;
        int stairs = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int i = 1; i <= stairs; i++) {
            if (n >= i)
                res++;
            else {
                break;
            }
            n -= i;
        }
        return res;
    }

    public int arrangeCoins(int n) {
        long res = 0;
        long s = 1, e = n % 2 == 0 ? n / 2 : n / 2 + 1;
        while (s <= e) {
            long m = s + (e - s) / 2;
            long sum = (m * (m + 1)) / 2;
            if (sum <= n) {
                res = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return (int) res;
    }
}