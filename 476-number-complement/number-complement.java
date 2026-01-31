class Solution {
    public int findComplement(int num) {
        int m = ~num;
        int n = 0;
        while (num > 0) {
            n = (n << 1) | 1;
            num = num >> 1;
        }
        return m & n;
    }
}