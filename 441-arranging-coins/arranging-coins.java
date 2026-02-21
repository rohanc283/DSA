class Solution {
    public int arrangeCoins(int n) {
        int res = 0;
        int stairs = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int i = 1; i <= n; i++) {
            if (n >= i)
                res++;
            else {
                break;
            }
            n -= i;
        }
        return res;
    }
}