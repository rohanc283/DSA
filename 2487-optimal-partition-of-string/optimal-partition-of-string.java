class Solution {
    public int partitionString(String s) {
        int res = 0;
        int mask = 0;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (((mask >> idx) & 1) >= 1) {
                mask = 0;
                res++;
            }
            int bit = 1 << idx;
            mask |= bit;
        }
        return res + 1;
    }
}