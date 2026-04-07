class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1 || k == 1)
            return '0';
        int len = (1 << n) - 1;
        int middlePos = 1 << (n - 1);
        if (middlePos == k)
            return '1';
        if (k < middlePos) {
            return findKthBit(n - 1, k);
        }
        char ch = findKthBit(n - 1, len - k + 1);
        return ch == '0' ? '1' : '0';
    }
}