class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int citation : citations) {
            if (citation > n) {
                bucket[n]++;
            } else {
                bucket[citation]++;
            }
        }

        int res = 0;
        for (int i = n; i >= 0; i--) {
            res += bucket[i];
            if (res >= i)
                return i;
        }
        return res;
    }
}