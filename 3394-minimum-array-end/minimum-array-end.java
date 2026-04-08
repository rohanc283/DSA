class Solution {
    private long sol1(int n, int x) {
        long num = x;
        for (int i = 0; i < n - 1; i++) {
            num = (num + 1) | x;
        }
        return num;
    }

    private long sol2(int n, int x) {
        long res = x;
        long rem = n - 1;
        long pos = 0;
        while (rem > 0) {
            if (((res >> pos) & 1) == 0) {
                if ((rem & 1) >= 1) {
                    res |= (1L << pos);
                }
                rem = rem >> 1;
            }
            pos++;
        }
        return res;
    }

    public long minEnd(int n, int x) {
        return sol2(n, x);
    }
}