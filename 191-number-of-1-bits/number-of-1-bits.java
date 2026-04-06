class Solution {
    public int hammingWeight(int n) {
        int r = 0;
        while (n > 0) {
            n = n & (n - 1);
            r++;
        }
        return r;
    }
}