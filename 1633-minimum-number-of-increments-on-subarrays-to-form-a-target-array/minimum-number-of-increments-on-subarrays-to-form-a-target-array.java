class Solution {
    public int minNumberOperations(int[] target) {
        int res = 0;
        int prev = 0;
        for (int tar : target) {
            if (tar > prev) {
                res += (tar - prev);
            }
            prev = tar;
        }
        return res;
    }
}